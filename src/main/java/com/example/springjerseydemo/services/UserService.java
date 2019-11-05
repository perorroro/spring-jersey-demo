package com.example.springjerseydemo.services;

import com.example.springjerseydemo.models.ApplicationUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<ApplicationUser> getUsers();
}