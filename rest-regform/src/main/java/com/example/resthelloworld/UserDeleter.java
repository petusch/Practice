package com.example.resthelloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserDeleter {

    @PostMapping("/delete")
    public void user() {

        //Delete User in database

    }
}