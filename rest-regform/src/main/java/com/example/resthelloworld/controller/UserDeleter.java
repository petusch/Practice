package com.example.resthelloworld.controller;

import com.example.resthelloworld.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserDeleter {

    @Autowired
    UserService userService;

    @PostMapping("/delete")
    public void user() {


    }
}