package com.example.resthelloworld.controller.usercontrollers;

import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.example.resthelloworld.controller.FormingRequest.formingRequest;


@RestController
public class UserDeleter {



    @Autowired
    Connection connection;



    @PostMapping("/deleteUser")
    public void user(@RequestParam Map<String,String> requestParams) {
        String request = formingRequest(requestParams, "delete","users");

        CompletableFuture<QueryResult> future = connection.sendPreparedStatement(request);

    }
}