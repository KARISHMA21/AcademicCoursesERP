package com.academia_courses.dao.impl;

import com.academia_courses.bean.Course;
import com.academia_courses.bean.Employee;
import com.academia_courses.dao.CourseUpdateDAO;
import com.academia_courses.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CourseUpdateDAOImpl implements CourseUpdateDAO {
    /*

    */

    @Override
    public List<Employee> showfacultylist(){

        List<Employee> facultylist = new ArrayList<>();

            try (Session session = HibernateSessionUtil.getSession()){
                for (
                        final Object faculty: session
                        .createQuery("FROM Employee where department=: isfaculty")
                            .setParameter("isfaculty", "faculty")
                        .list()
                )
                 //   System.out.println(course);
                    facultylist.add((Employee) faculty);
               // System.out.println("=============================300000000000000000000000==================================================================");
                //  System.out.println(course);

               // System.out.println("==========================3333333333333333333333333333333333=====================================================================");
            }
            catch (HibernateException exception) {
                System.out.println(exception.getLocalizedMessage());
            }

            return facultylist;
        }

    @Override
    public List<Course> showprerequisitelist() {
        List<Course> PrerequisiteList = new ArrayList<>();
        try (Session session = HibernateSessionUtil.getSession()){
            for (
                    final Object course: session
                    .createQuery("FROM Course ")
                    .list()
            )
                //   System.out.println(course);
                PrerequisiteList.add((Course) course);
            // System.out.println("=============================300000000000000000000000==================================================================");
            //  System.out.println(course);

            // System.out.println("==========================3333333333333333333333333333333333=====================================================================");
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        return PrerequisiteList;

    }
}

/*
his.course_name = course_name;
        this.course_description = course_description;
        this.course_year = course_year;
        this.course_term = course_term;
        this.course_credits = course_credits;
        this.course_capacity = course_capacity;
        this.course_faculty = course_faculty;


 "FROM Employee WHERE email = :Email and password = :Password"
         )
         .setParameter("Email", Email)
         .setParameter("Password", Password)
         .list()


 */