package com.academia_courses.controller;

import com.academia_courses.bean.Course;
import com.academia_courses.bean.Employee;
import com.academia_courses.service.UpdateService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;

import java.util.List;

@Path("courseupdate")
public class CourseUpdateController {

    UpdateService updateservice = new UpdateService();

    /*
        Path: GET /api/bill?studentId={studentId}
        Input: {studentId}
        Response: 200 Status Code with the Bills of the student (if Authorization added, would need to change this)
        Description: Return all bills of the Student with id = {studentId}
    */
    @GET
    @Path("facultylist")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showfacultylist() {
        List<Employee> facultylist = updateservice.showfacultylist();
        if (facultylist == null)
            return Response.status(410).build();
        else
           return Response.ok().entity(facultylist).build();
    }

    @GET
    @Path("prerequisiteList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showprerequisitelist() {
        List<Course> PrerequisiteList = updateservice.showprerequisitelist();
        if (PrerequisiteList == null)
            return Response.status(410).build();
        else
           return Response.ok().entity(PrerequisiteList).build();
    }


}
