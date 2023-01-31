package com.academia_courses.service;

import com.academia_courses.bean.Employee;

import com.academia_courses.dao.impl.AdminDAOImpl;


public class LoginService {
    AdminDAOImpl adminDAO = new AdminDAOImpl();

    public Employee login(Employee admin){
        //Student loggedInStudent = studentDAO.login(student);
        Employee login_admin = adminDAO.login(admin);

        // If no login happens, then return null
        if (login_admin == null)
            return null;

        // Setting billList to null to avoid cyclic dependency issues
       // loggedInStudent.setBillList(null);

        return login_admin;
    }

}