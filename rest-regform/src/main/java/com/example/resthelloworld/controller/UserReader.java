package com.example.resthelloworld.controller;

import com.example.resthelloworld.entity.User;
import com.example.resthelloworld.services.UserService;
import com.example.resthelloworld.services.impl.UserServiceImpl;
import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.QueryResult;
import com.github.jasync.sql.db.RowData;
import com.github.jasync.sql.db.postgresql.PostgreSQLConnectionBuilder;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static com.example.resthelloworld.controller.FormingRequest.formingRequest;


@RestController
public class UserReader {

    @Autowired
    UserService userService;

    @Autowired
    Connection connection;

    @PostMapping("/readAll")
    public List<User> readAll() {
        CompletableFuture<List<User>>future = connection.sendPreparedStatement("select * from users")
                .thenApply(result -> result.getRows()
                        .stream()
                        .map((RowData rowData) -> new User(rowData.getString("name"),
                                rowData.getString("surname"),
                                rowData.getString("email"),
                                rowData.getDate("birthdate"),
                                rowData.getDate("creationdate")))
                        .collect(Collectors.toList())
                );
        List<User> list = future.join();
        for(User user : list)
        {
            System.out.println(user.toString());
        }
        return list;
    }

    @PostMapping("/read")
    public List<User> read(@RequestParam Map<String,String> requestParams)
    {

        String request = formingRequest(requestParams, "read","users");
        CompletableFuture<List<User>>future = connection.sendPreparedStatement(request)
                .thenApply(result -> result.getRows()
                        .stream()
                        .map((RowData rowData) -> new User(rowData.getString("name"),
                                rowData.getString("surname"),
                                rowData.getString("email")))
                        .collect(Collectors.toList())
                );
        List<User> list = future.join();
        for(User user : list)
        {
            System.out.println(user.toString());
        }
        return list;
    }

}