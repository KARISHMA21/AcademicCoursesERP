package com.academia_courses.dao.impl;

import com.academia_courses.bean.Course;
import com.academia_courses.bean.Employee;
import com.academia_courses.dao.CourslistDAO;
import com.academia_courses.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Internal;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class CourselistDAOImpl implements CourslistDAO {
    /*

    */

    @Override
    public List<Course> showcoursedetails() {

        List<Course> courselist = new ArrayList<>();

            try (Session session = HibernateSessionUtil.getSession()){
                for (
//                        final Object course: session
//                        .createQuery("FROM Course c JOIN Employee e on c.employee.employeeid = e.employeeid").list()
                final Object course: session
                        .createQuery("FROM Course ").list()

               // select * from course c JOIN course_schedule cs on c.course_id=cs.course_id
/*
                select concat(fname, ' ', minit, ' ', lname)
                item.id}</td>
                                        <td>{item.course_code}</td>
                                        <td>{item.course_name}</td>
                                        <td>{item.course_description}</td>
                                        <td>{item.course_year}</td>
                                        <td>{item.course_term}</td>
                                        <td>{item.course_credits}</td>
                                        <td>{item.course_capacity}</td>
                                        <td><ul>{item.course_prerequisites.split(',').map((items, i)=>(<li key={i}>{items}</li>))}</ul></td>
                                        <td>{item.course_faculty}<

 */

                )
                 //   System.out.println(course);
                    courselist.add((Course) course);
               // System.out.println("=============================300000000000000000000000==================================================================");
                //  System.out.println(course);

               // System.out.println("==========================3333333333333333333333333333333333=====================================================================");
            }
            catch (HibernateException exception) {
                System.out.println(exception.getLocalizedMessage());
            }

            return courselist;
        }

    @Override
    public  Boolean removecourse(Integer courseid) {
        System.out.println("=================================================================================================");
        System.out.println("Removing course : " + courseid);
        System.out.println("===============================================================================================");

        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            String query_string="DELETE FROM Course WHERE id=:courseid";
            Query query=session.createQuery(query_string);
            query.setParameter("courseid", courseid);
            query.executeUpdate();
            transaction.commit();
            return true;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return false;
    }

    @Override
    public Course showcoursedetails(Integer courseid){
        try (Session session = HibernateSessionUtil.getSession()){

            System.out.println("==================================================================================================");
            System.out.println(" In edit page of course :"+ courseid);
            System.out.println("===============================================================================================");
            List<Object> result = new ArrayList<Object>(
                    session.createQuery(
                                //    "FROM Course WHERE id = :courseid"
                                    "FROM Course c  JOIN Employee e on c.employee.employeeid = e.employeeid WHERE c.id = :courseid"
                            )
                            .setParameter("courseid", courseid)
                            .list()
            );
            System.out.println("==================================================================================================");
            System.out.println(result);
            System.out.println("===============================================================================================");
            // If no valid admin found, return null so that login failure is understood
            if (result.size() == 0)
                return null;
            else
                return (Course) result.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }

    public Boolean updatecourse(Integer courseid,Course coursedetails_update){
        System.out.println("=================================================================================================");
        System.out.println("Updating course : " + courseid);
        System.out.println("===============================================================================================");

        try (Session session = HibernateSessionUtil.getSession()) {

            Integer Id = coursedetails_update.getId();
            String code = coursedetails_update.getCourse_code();
            String name = coursedetails_update.getCourse_name();
            String description = coursedetails_update.getCourse_description();
            Integer year = coursedetails_update.getCourse_year();
            Integer term = coursedetails_update.getCourse_term();
            Integer credits = coursedetails_update.getCourse_credits();
            String faculty = coursedetails_update.getDummy();
            Integer capacity = coursedetails_update.getCourse_capacity();
            System.out.println("================ updated faculty is "+faculty+"=================");

//            List<Integer> result = new ArrayList<>(session.createQuery(
//                                    "select employeeid FROM Employee where employeename = :updatedname")
//
//                            .setParameter("updatedname", faculty).list()
//            );

            Query query1 = session.createQuery(  "select employeeid FROM Employee where employeename = :updatedname");
            query1.setParameter("updatedname",faculty);
            Integer result = (Integer) query1.uniqueResult();

//            Query query=session.createQuery(query_string);
//            query.setParameter("courseid", courseid);
//            query.executeUpdate();
//            transaction.commit();

            System.out.println("============result========="+result+"===========================");

            Transaction transaction = session.beginTransaction();
            String query_string="UPDATE Course set course_name=:course_name," +
                    " course_description=:course_description," +
                    "course_year=:course_year, " +
                    "course_term =:course_term," +
                    "course_credits =: course_credits," +
                    "employee.employeeid =: facultyid,"+
                    "course_capacity =: course_capacity WHERE id=:courseid";
            Query query=session.createQuery(query_string);
            query.setParameter("course_name", name);
            query.setParameter("course_description", description);
            query.setParameter("course_year",year);
            query.setParameter("course_term",term);
            query.setParameter("course_credits",credits);
            query.setParameter("course_capacity",capacity);
            query.setParameter("facultyid",result);
            query.setParameter("courseid", courseid);
            query.executeUpdate();
            transaction.commit();
            return true;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return false;

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