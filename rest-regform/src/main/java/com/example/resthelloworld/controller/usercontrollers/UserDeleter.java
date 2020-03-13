package com.example.resthelloworld.controller.usercontrollers;

import com.example.resthelloworld.services.UserService;
import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.example.resthelloworld.services.impl.FormingRequest.formingRequest;


@RestController
public class UserDeleter {



    @Autowired
    Connection connection;

    @Resource
    UserService userService;

    @PostMapping("/deleteUser")
    public void user(@RequestParam Map<String,String> requestParams) {

    userService.deleteById(requestParams);

    }
}
