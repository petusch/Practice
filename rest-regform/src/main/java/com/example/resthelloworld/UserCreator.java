package com.example.resthelloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserCreator {

    @GetMapping(value ={"/test", "/create"})
    public User user() {
        User user = new User("Oleg","Chernyshow", 946684800000L);

        //Create User in database

        return user;
    }
}