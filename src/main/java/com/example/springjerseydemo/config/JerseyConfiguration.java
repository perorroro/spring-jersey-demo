package com.example.springjerseydemo.config;

import com.example.springjerseydemo.controllers.AuthenticationController;
import com.example.springjerseydemo.controllers.UserController;
import com.example.springjerseydemo.mappers.CustomExceptionMapper;
import com.example.springjerseydemo.models.ApplicationUser;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;



import javax.annotation.PostConstruct;

@Configuration
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {

        register(new org.glassfish.hk2.utilities.binding.AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(UserContextFactory.class)
                        .to(ApplicationUser.class)
                        .in(RequestScoped.class);
            }
        });
    }

    @PostConstruct
    public void init() {
        register(UserController.class);
        register(AuthenticationController.class);
        register(CustomExceptionMapper.class);
    }
}