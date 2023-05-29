package com.teacherStudent.webSpringProject.student;


import jakarta.validation.constraints.Pattern;

public class Student {

    public static int nbStudents = 0;

    private long id;
    @Pattern(regexp="^[A-Z]+[a-z]{3,20}$",message="Enter a proper name with capital first letter")
    private String name;

    //private String surname;
    private int studyYear;

    public Student() {
    }
    public Student(long id, String name, int studyYear) {
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

    public void setId(long id) {
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