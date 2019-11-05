package com.example.springjerseydemo.config;

import com.example.springjerseydemo.models.ApplicationUser;
import org.glassfish.hk2.api.Factory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserContextFactory implements Factory<ApplicationUser> {


    @Override
    public ApplicationUser provide() {

        String firstname;
        String lastname;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof ApplicationUser) {
            firstname = ((ApplicationUser) principal).getFirstName();
            lastname = ((ApplicationUser) principal).getLastName();

            return new ApplicationUser(firstname, lastname);
        } else {
            throw new AccessDeniedException("Can't extract user from provided jwt");
        }
    }

    @Override
    public void dispose(ApplicationUser t) {
    }

}
