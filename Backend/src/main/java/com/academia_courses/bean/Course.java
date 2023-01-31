package com.academia_courses.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;


@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="courseCode",nullable = false, unique = true)
    private String course_code;

    @Column(name="courseName",nullable = false)
    private String course_name;

    @Column(name="description")
    private String course_description;

    @Column(name="year",nullable = false)
    private Integer course_year;

    @Column(name="term",nullable = false)
    private Integer course_term;

    @Column(name="credits",nullable = false)
    private Integer course_credits;

    @Column()
    private String dummy;
    @Column(name="capacity",nullable = false)
    private Integer course_capacity;

    @ManyToOne
    @JoinColumn(name = "facultyid",nullable = false)
    private Employee employee;



    @ManyToMany(fetch = FetchType.EAGER,cascade={CascadeType.REMOVE})
    @JoinTable(name="Course_Prerequisite",
           joinColumns = {@JoinColumn(name="Course_id", referencedColumnName = "id", unique = false)},
            inverseJoinColumns = {@JoinColumn(name="prerequisite_id", referencedColumnName = "id", unique = false)})
   // @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Course> Prerequisite;

    public Course() {
    }

    public Course(Integer id, String course_code, String course_name, String course_description, Integer course_year, Integer course_term, Integer course_credits, String dummy, Integer course_capacity) {
        this.id = id;
        this.course_code = course_code;
        this.course_name = course_name;
        this.course_description = course_description;
        this.course_year = course_year;
        this.course_term = course_term;
        this.course_credits = course_credits;
        this.dummy = dummy;
        this.course_capacity = course_capacity;
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

    public String getDummy() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy = dummy;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Course> getPrerequisite() {
        return Prerequisite;
    }

    public void setPrerequisite(List<Course> prerequisite) {
        Prerequisite = prerequisite;
    }


}

/* "id": 3,
  "course_code": "test1",
      "course_name": "TestUser1",
      "course_description": "testuser1@melissa.tv",
      "course_year": "testuser1.neter",
      "course_term": "700",
      "course_credits": "600",
      "course_capacity": "12",
      "course_prerequisites": "Java, Javascript, Nodejs" */