package com.academia_courses.controller;

import com.academia_courses.bean.Course;
import com.academia_courses.service.CoursesService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("courselist")
public class CourselistController {

    CoursesService courseservice = new CoursesService();

    /*
        Path: GET /api/bill?studentId={studentId}
        Input: {course id }

    */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showallcoursedetails() {
        List<Course> courseList = courseservice.showallcoursedetails();
        if (courseList == null)
            return Response.status(410).build();
        else
           return Response.ok().entity(courseList).build();
    }

    @DELETE
    @Path("/{courseid}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deletecourse(@PathParam("courseid") Integer courseid) {
        Boolean courseremoved = courseservice.removecourse(courseid);
        if (courseremoved)
            return Response.status(200).build();
        else
            return Response.status(400).build();
    }

    @GET
    @Path("/{courseid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response coursedetailsshow (@PathParam("courseid") Integer courseid) {
        Course coursedetails = courseservice.showcoursedetails(courseid);
        if (coursedetails == null)
            return Response.status(410).build();
        else
            return Response.ok().entity(coursedetails).build();
    }

    @PUT
    @Path("/{courseid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatecourse(@PathParam("courseid") Integer courseid,Course coursedetails_update) {
        Boolean courseupdated = courseservice.updatecourse(courseid, coursedetails_update);
        if (courseupdated == null)
            return Response.status(400).build();
        else
            return Response.ok().entity(courseupdated).build();
    }


}
