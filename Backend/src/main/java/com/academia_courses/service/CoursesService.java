package com.academia_courses.service;

import java.util.List;

import com.academia_courses.bean.Course;
import com.academia_courses.bean.Employee;
import com.academia_courses.dao.impl.CourselistDAOImpl;

public class CoursesService {


    CourselistDAOImpl courselistDAO = new CourselistDAOImpl();
    public List<Course> showallcoursedetails() {
        List<Course> courseList = courselistDAO.showcoursedetails();

        return courseList;
    }

    public Boolean removecourse(Integer courseid) {

        return courselistDAO.removecourse(courseid);
    }

  //;

    public Course showcoursedetails(Integer courseid){

        Course coursedetails = courselistDAO.showcoursedetails(courseid);

        // If no login happens, then return null
        if (coursedetails == null)
            return null;

        // Setting billList to null to avoid cyclic dependency issues
        // loggedInStudent.setBillList(null);

        return coursedetails;
    }

    public Boolean updatecourse(Integer courseid,Course coursedetails_update) {
        return courselistDAO.updatecourse(courseid,coursedetails_update);
    }


}