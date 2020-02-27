package com.example.resthelloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserUpdater {

    @GetMapping("/update")
    public User user() {
        User user = new User("Oleg","Chernyshow", 946684800000L);

        //Update User in database

        return user;
    }
}