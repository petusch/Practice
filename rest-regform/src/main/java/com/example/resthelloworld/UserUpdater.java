package com.example.resthelloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserUpdater {

    @PostMapping("/update")
    public User user() {
        User user = new User("Oleg","Chernyshow", "email@gmail.com", 946684800000L);

        //Update User in database

        return user;
    }
}