package com.teacherStudent.webSpringProject.student;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("username")
public class StudentControllerJpa {

    public StudentControllerJpa(StudentRepository studentRepository){
        super();
        this.studentRepository = studentRepository;
    }

    private static int studyYear;

    private int basicStudyYear = 1;

//    private StudentService studentService;

    private StudentRepository studentRepository;

    @RequestMapping("list-students")
    public String listAllStudents(ModelMap model) {
        String username = getLoggedInUsername();
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "listStudents";
    }

    private String getLoggedInUsername(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value = "add-student", method = RequestMethod.GET)
    public String showAddStudentPage(ModelMap model) {
        String studentName = (String)model.get("name");
        Student student = new Student(0, studentName, 1);
        model.put("student", student);
        return "addStudent";
    }

//    @RequestMapping (value="add-student",method= RequestMethod.POST)
//    public String AddNewStudent(ModelMap model, Student student){
//
//        studentService.addStudent(student.getName());
//        return "redirect:list-students";
//    }

    //Version with validation
    @RequestMapping(value = "add-student", method = RequestMethod.POST)
    public String AddNewStudent(ModelMap model, @Valid Student student, Errors error) {
        if (error.hasErrors()) {
            return "addStudent";
        }
        student.setStudyYear(basicStudyYear);
        studentRepository.save(student);
//        studentService.addStudent(student.getName());
        return "redirect:list-students";
    }

    @RequestMapping("remove-student")
    public String removeStudent(@RequestParam int id) {
        studentRepository.deleteById(id);
        return "redirect:list-students";
    }

    @RequestMapping(value = "update-student", method = RequestMethod.GET)
    public String updateStudentPage(@RequestParam int id, ModelMap model) {
        Student student = studentRepository.findById(id).get();
        studyYear = student.getStudyYear();
        model.addAttribute("student", student);
        return "addStudent";
    }

    @RequestMapping(value = "update-student", method = RequestMethod.POST)
    public String UpdateStudent(ModelMap model, @Valid Student student, Errors error) {
        if (error.hasErrors()) {
            return "addStudent";
        }
        student.setStudyYear(studyYear);
        studentRepository.save(student);
        return "redirect:list-students";
    }
}
