package com.teacherStudent.webSpringProject.teacher;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;

@Entity
public class Teacher {

    public static int nbTeachers = 0;

    @Id
    @GeneratedValue
    private int id;

    @Pattern(regexp="^[A-Z]+[a-z]{3,20}$",message="Enter a proper name with capital first letter and a minimum of 4 characters")
    private String name;
    private String course;

    public Teacher() {
    }

    public Teacher(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

}