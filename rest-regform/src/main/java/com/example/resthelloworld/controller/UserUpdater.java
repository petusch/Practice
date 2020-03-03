package com.example.resthelloworld.controller;

import com.example.resthelloworld.entity.User;
import com.example.resthelloworld.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserUpdater {

    @Autowired
    UserService userService;

    @PostMapping("/update")
    public User user() {
        User user = new User("Oleg","Chernyshow", "email@gmail.com", 946684800000L);

        //Update User in database

        return user;
    }
}