package com.example.springjerseydemo.services;

import com.example.springjerseydemo.models.ApplicationUser;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<ApplicationUser> getUsers() {
        return Arrays.asList(
                new ApplicationUser("SomeOther","user1Pass","Some","User"),
                new ApplicationUser("SomeOtherUser","user1Pass","SomeOther","User")
        );
    }

    @Override
    public ApplicationUser loadUserByUsername(String firstName) {
        if (firstName.equals("some")){
            return new ApplicationUser("Some","User");
        } else if (firstName.equals("SomeOther")){
            return new ApplicationUser("SomeOther","User");
        } else if (firstName.equals("SomethingOther")){
            return new ApplicationUser("SomethingOther","ThenThis");
        }
        else return null;
    }

}
