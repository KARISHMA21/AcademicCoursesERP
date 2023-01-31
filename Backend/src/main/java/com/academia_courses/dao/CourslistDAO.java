package com.academia_courses.dao;

import com.academia_courses.bean.Course;
import com.academia_courses.bean.Employee;

import java.util.List;

public interface CourslistDAO {
    List<Course> showcoursedetails();
    Boolean removecourse(Integer courseid);

    Course showcoursedetails(Integer courseid);

    Boolean updatecourse(Integer courseid,Course coursedetails_update);

}
