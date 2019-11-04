package com.example.springjerseydemo.controllers;

import com.example.springjerseydemo.models.ApplicationUser;
import com.example.springjerseydemo.services.UserService;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.util.Arrays;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Context
    private HttpServletRequest request;


    @GET
    @Produces(APPLICATION_JSON)
    @Context
    public List getClients(ApplicationUser user) throws InterruptedException {
   //     System.out.println(request.getRequestURI());
        Thread.sleep(20000000l);
        return Arrays.asList(user);
    }


}
