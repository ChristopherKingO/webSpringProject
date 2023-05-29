package com.teacherStudent.webSpringProject.teacher;

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
public class TeacherControllerJpa {

    public TeacherControllerJpa(TeacherRepository teacherRepository) {
        super();
        this.teacherRepository = teacherRepository;
    }

    private TeacherRepository teacherRepository;

    private String getLoggedInUsername(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping("list-teachers")
    public String listAllTeachers(ModelMap model){
        String username = getLoggedInUsername();
        List<Teacher> teachers = teacherRepository.findAll();
        model.addAttribute("teachers",teachers);
        return "listTeachers";
    }

    @RequestMapping(value="add-teacher" , method = RequestMethod.GET)
    public String showAddTeacherPage(ModelMap model){
        String teacherName = (String)model.get("name");
        String teacherCourse = (String)model.get("course");
        Teacher teacher = new Teacher(0,teacherName,teacherCourse);
        model.put("teacher",teacher);
        return "addTeacher";
    }
    @RequestMapping(value = "add-teacher", method = RequestMethod.POST)
    public String addNewTeacher(ModelMap model, @Valid Teacher teacher , Errors error){
        if (error.hasErrors()){
            return "addTeacher";
        }
        teacherRepository.save(teacher);
        return "redirect:list-teachers";
    }

    @RequestMapping("remove-teacher")
    public String removeTeacher(@RequestParam int id){
        teacherRepository.deleteById(id);
        return "redirect:list-teachers";
    }


}
