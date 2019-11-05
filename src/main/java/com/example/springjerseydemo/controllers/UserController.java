package com.example.springjerseydemo.controllers;

import com.example.springjerseydemo.models.ApplicationUser;
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

    @Context
    private HttpServletRequest request;

    @Context
    private ApplicationUser user;

    @GET
    @Produces(APPLICATION_JSON)
    public List getClients() {
        System.out.println(user.getFirstName());
        return Arrays.asList(user);
    }

}
