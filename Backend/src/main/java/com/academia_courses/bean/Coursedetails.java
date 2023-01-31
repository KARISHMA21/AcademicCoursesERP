package com.academia_courses.bean;


public class Coursedetails {

    Integer id;
    String course_code;
    String course_name;
    String course_description;
    Integer course_year;
    Integer course_term;
    Integer  course_credits;
    Integer course_capacity;
    String course_faculty;



    public Coursedetails(Integer id, String course_code, String course_name, String course_description, Integer course_year, Integer course_term, Integer course_credits, Integer course_capacity, String course_faculty) {
        this.id = id;
        this.course_code = course_code;
        this.course_name = course_name;
        this.course_description = course_description;
        this.course_year = course_year;
        this.course_term = course_term;
        this.course_credits = course_credits;
        this.course_capacity = course_capacity;
        this.course_faculty = course_faculty;
    }

    public Coursedetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public Integer getCourse_year() {
        return course_year;
    }

    public void setCourse_year(Integer course_year) {
        this.course_year = course_year;
    }

    public Integer getCourse_term() {
        return course_term;
    }

    public void setCourse_term(Integer course_term) {
        this.course_term = course_term;
    }

    public Integer getCourse_credits() {
        return course_credits;
    }

    public void setCourse_credits(Integer course_credits) {
        this.course_credits = course_credits;
    }

    public Integer getCourse_capacity() {
        return course_capacity;
    }

    public void setCourse_capacity(Integer course_capacity) {
        this.course_capacity = course_capacity;
    }

    public String getCourse_faculty() {
        return course_faculty;
    }

    public void setCourse_faculty(String course_faculty) {
        this.course_faculty = course_faculty;
    }


}
