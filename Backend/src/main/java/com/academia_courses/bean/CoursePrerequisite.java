package com.academia_courses.bean;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="courseprerequisite")
public class CoursePrerequisite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prerequisiteid;

//    @ManyToOne(cascade={CascadeType.ALL})
//    @JoinColumn(name = "courseid")
//    private Course course;course

//    @ManyToOne
//    @JoinColumn(name = "courseid")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Course coursep;

    @Column(nullable = false)
    private String course_prerequisites;

    public CoursePrerequisite() {
    }

//    public CoursePrerequisite(Integer prerequisiteid, Course course_id, String course_prerequisites) {
//        this.prerequisiteid = prerequisiteid;
//        this.coursep = coursep;
//        this.course_prerequisites = course_prerequisites;
//    }

    public Integer getPrerequisiteid() {
        return prerequisiteid;
    }

    public void setPrerequisiteid(Integer prerequisiteid) {
        this.prerequisiteid = prerequisiteid;
    }

//    public Course getCourse_id() {
//        return coursep;
//    }
//
//    public void setCourse_id(Course course_id) {
//        this.coursep = course_id;
//    }

    public String getCourse_prerequisites() {
        return course_prerequisites;
    }

    public void setCourse_prerequisites(String course_prerequisites) {
        this.course_prerequisites = course_prerequisites;
    }
}
