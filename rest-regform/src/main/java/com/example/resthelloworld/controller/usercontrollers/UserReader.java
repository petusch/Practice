package com.example.resthelloworld.controller.usercontrollers;

import com.example.resthelloworld.entity.User;
import com.example.resthelloworld.services.UserService;
import com.github.jasync.sql.db.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;



@RestController
public class UserReader {

    @Autowired
    Connection connection;

    @Resource
    UserService userService;

    @PostMapping("/readUsers")
    public List<User> readAll() {
        List<User> list = userService.readAll();
        return list;
    }

    @PostMapping("/readUser")
    public List<User> read(@RequestParam Map<String,String> requestParams)
    {
        return userService.read(requestParams);
    }

}
