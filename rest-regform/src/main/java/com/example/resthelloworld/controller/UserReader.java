package com.example.resthelloworld.controller;

import com.example.resthelloworld.entity.User;
import com.example.resthelloworld.services.UserService;
import com.example.resthelloworld.services.impl.UserServiceImpl;
import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.QueryResult;
import com.github.jasync.sql.db.RowData;
import com.github.jasync.sql.db.postgresql.PostgreSQLConnectionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;


@RestController
public class UserReader {

    @Autowired
    UserService userService;

    @PostMapping("/readall")
    public void readAll() throws ExecutionException, InterruptedException {

        List<User> allUsers = new ArrayList<User>();

        Connection connection = PostgreSQLConnectionBuilder.createConnectionPool(
                "jdbc:postgresql://localhost:5432/RegForm");

        CompletableFuture<List<User>>future = connection.sendPreparedStatement("select * from users")
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
            System.out.println(user.getEmail());
        }
        return;
    }
}