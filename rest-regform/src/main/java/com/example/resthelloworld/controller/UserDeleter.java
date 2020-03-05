package com.example.resthelloworld.controller;

import com.example.resthelloworld.entity.User;
import com.example.resthelloworld.services.UserService;
import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.QueryResult;
import com.github.jasync.sql.db.RowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.example.resthelloworld.controller.FormingRequest.formingRequest;


@RestController
public class UserDeleter {

    @Autowired
    UserService userServices;

    @Autowired
    Connection connection;

//    @PostMapping("/delete")
//    public void user(@RequestBody String request) {
//
//        CompletableFuture<QueryResult> future = connection.sendPreparedStatement(request);
//
//    }

    @PostMapping("/delete")
    public void user(@RequestParam Map<String,String> requestParams) {
        String request = formingRequest(requestParams, "delete","users");

        CompletableFuture<QueryResult> future = connection.sendPreparedStatement(request);

    }
}