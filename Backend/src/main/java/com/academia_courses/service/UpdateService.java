package com.academia_courses.service;

import com.academia_courses.bean.Course;
import com.academia_courses.bean.Employee;
import com.academia_courses.dao.impl.CourseUpdateDAOImpl;

import java.util.List;

public class UpdateService {


    CourseUpdateDAOImpl courseupdateDAO = new CourseUpdateDAOImpl();
    public List<Employee> showfacultylist() {
        List<Employee> facultylist = courseupdateDAO.showfacultylist();

        return facultylist;
    }

    public List<Course> showprerequisitelist(){
        List<Course> PrerequisiteList = courseupdateDAO.showprerequisitelist();
        return PrerequisiteList;
    }


}
