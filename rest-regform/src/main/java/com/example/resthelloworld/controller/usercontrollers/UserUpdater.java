package com.example.resthelloworld.controller.usercontrollers;

import com.example.resthelloworld.entity.User;
import com.github.jasync.sql.db.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserUpdater {



    @Autowired
    Connection connection;

    @PostMapping("/updateUser")
    public User user(@RequestBody String request) {
        User user = new User("Oleg","Chernyshow", "email@gmail.com", 946684800000L);



        return user;
    }
}
