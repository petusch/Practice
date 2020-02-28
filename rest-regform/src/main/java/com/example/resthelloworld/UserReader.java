package com.example.resthelloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserReader {

    @PostMapping("/read")
    public User user() {
        User user = new User("Oleg","Chernyshow", "some@gmail.com",946684800000L);

        //Read User in database

        return user;
    }
}