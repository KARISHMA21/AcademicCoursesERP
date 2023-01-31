package com.academia_courses.controller;

import com.academia_courses.bean.Employee;
import com.academia_courses.service.LoginService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("employee")
public class LoginController {
    LoginService loginService = new LoginService();

    /*
        Path: POST /api/student/login
        Input: Student Object whose schema is defined in com.academia.payment.bean.Student
        Response: 200 (OK) + logged in Student object if login succeeded else 401 (Bad Request) with no body
    */
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Employee admin) {
        Employee login_admin = loginService.login(admin);

        if (login_admin == null)
            return Response.status(400).build();
        else
            return Response.ok().entity(login_admin).build();
    }
}