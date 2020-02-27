package com.example.resthelloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserReader {

    @GetMapping("/read")
    public User user() {
        User user = new User("Oleg","Chernyshow", 946684800000L);

        //Read User in database

        return user;
    }
}