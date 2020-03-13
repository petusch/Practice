package com.example.resthelloworld.controller.usercontrollers;

import com.example.resthelloworld.entity.User;
import com.example.resthelloworld.services.UserService;
import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.RowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.example.resthelloworld.services.impl.FormingRequest.formingRequest;


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
