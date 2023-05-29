package com.teacherStudent.webSpringProject.student;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;

@Entity
public class Student {

    public static int nbStudents = 0;

    @Id
    @GeneratedValue
    private int id;
    @Pattern(regexp="^[A-Z]+[a-z]{3,20}$",message="Enter a proper name with capital first letter")
    private String name;

    //private String surname;
    private int studyYear;

    public Student() {
    }
    public Student(int id, String name, int studyYear) {
        this.id = id;
        this.name = name;
        this.studyYear = studyYear;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studyYear='" + studyYear + '\'' +
                '}';
    }
}