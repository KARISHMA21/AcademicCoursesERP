package com.academia_courses.dao;

import com.academia_courses.bean.Employee;

public interface AdminDAO {
    Employee login(Employee admin);
    //void createStudent(Employee admin);
}
