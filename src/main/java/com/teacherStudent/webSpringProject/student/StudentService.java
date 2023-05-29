package com.teacherStudent.webSpringProject.student;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static com.teacherStudent.webSpringProject.student.Student.nbStudents;

@Service
public class StudentService {

    private static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(++nbStudents,"David",3));
        students.add(new Student(++nbStudents,"Michael",3));
        students.add(new Student(++nbStudents,"Jarvey",2));
    }

    public List<Student> findByName(String username){
        return students;
    }
//    public List<Student> findByName(String username){
//        Predicate<? super Student> predicate =
//                student -> student.getName().equalsIgnoreCase(username);
//        return students.stream().filter(predicate).toList();
//    }

    public void addStudent(String name){
        Student newStudent = new Student(++nbStudents,name,1);
        students.add(newStudent);
    }


    public void removeStudentById(long id){
        Predicate<? super Student> predicate =
                student -> student.getId()==id;

        students.removeIf(predicate);
    }

    public Student findById(long id) {
        Predicate<? super Student> predicate =
                student -> student.getId()==id;
        Student studentF = students.stream().filter(predicate).findFirst().get();
        return studentF;
    }

    public void updateStudent(@Valid Student student) {
        Student studentF = findById(student.getId());
        student.setStudyYear(studentF.getStudyYear());
        removeStudentById(studentF.getId());
        students.add(student);
    }
}
