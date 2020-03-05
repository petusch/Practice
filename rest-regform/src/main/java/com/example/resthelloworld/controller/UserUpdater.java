package com.example.resthelloworld.controller;

import com.example.resthelloworld.entity.User;
import com.example.resthelloworld.services.UserService;
import com.github.jasync.sql.db.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserUpdater {

    @Autowired
    UserService userService;

    @Autowired
    Connection connection;

    @PostMapping("/update")
    public User user(@RequestBody String request) {
        User user = new User("Oleg","Chernyshow", "email@gmail.com", 946684800000L);

        //Update User in database

        return user;
    }
}