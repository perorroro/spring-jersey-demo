package com.example.springjerseydemo.config;

import com.example.springjerseydemo.models.ApplicationUser;
import com.example.springjerseydemo.services.UserService;
import org.glassfish.hk2.api.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserContextFactory implements Factory<ApplicationUser> {


    @Autowired
    UserService userService;

    @Override
    public ApplicationUser provide() {

        String firstname;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof ApplicationUser) {

            firstname = ((ApplicationUser) principal).getFirstName();
        } else {
            throw new AccessDeniedException("Can't extract user from provided jwt");
        }
        return userService.loadUserByUsername(firstname);
    }

    @Override
    public void dispose(ApplicationUser t) {
    }

}
