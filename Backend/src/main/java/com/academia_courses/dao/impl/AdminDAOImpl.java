package com.academia_courses.dao.impl;

import com.academia_courses.bean.Employee;
import com.academia_courses.dao.AdminDAO;
import com.academia_courses.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    /*
        This method performs login of the Student object specified
        So it basically checks whether the credentials provided in the Student object match with
        a Student object in the database
    */
    @Override
    public Employee login(Employee admin) {
        try (Session session = HibernateSessionUtil.getSession();){
            String Email = admin.getEmail();
            String Password = admin.getPassword();
            System.out.println("==================================================================================================");
            System.out.println(Email + Password);
            System.out.println("===============================================================================================");
            List<Object> result = new ArrayList<Object>(
                session.createQuery(
                        "FROM Employee WHERE email = :Email and password = :Password"
                        )
                        .setParameter("Email", Email)
                        .setParameter("Password", Password)
                        .list()
            );
        System.out.println("==================================================================================================");
            System.out.println(result);
            System.out.println("===============================================================================================");
            // If no valid admin found, return null so that login failure is understood
            if (result.size() == 0)
                return null;
            else
                return (Employee) result.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }

    /*
        This method inserts the provided Student object into the database
        Used by the InitializeDB script to initialize the database with dummy data

    @Override
    public void createEmployee(Employee admin) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(admin);
            transaction.commit();
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
    }

     */
}