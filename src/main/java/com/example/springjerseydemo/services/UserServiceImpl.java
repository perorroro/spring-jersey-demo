package com.example.springjerseydemo.services;

import com.example.springjerseydemo.models.ApplicationUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<ApplicationUser> getUsers() {
        return Arrays.asList(
                new ApplicationUser("Some","user1Pass","Some","User"),
                new ApplicationUser("SomeOther","user1Pass","SomeOther","User")
        );
    }

    @Override
    public ApplicationUser loadUserByUsername(String firstName) {
        if (firstName.equalsIgnoreCase("some")){
            return new ApplicationUser("Some","User");
        } else if (firstName.equalsIgnoreCase("SomeOther")){
            return new ApplicationUser("SomeOther","User");
        } else if (firstName.equalsIgnoreCase("SomethingOther")){
            return new ApplicationUser("SomethingOther","ThenThis");
        }
        else return null;
    }

}
