package com.example.resthelloworld.controller.usercontrollers;

import com.example.resthelloworld.entity.User;
import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.RowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.example.resthelloworld.controller.FormingRequest.formingRequest;


@RestController
public class UserReader {



    @Autowired
    Connection connection;

    @PostMapping("/readUsers")
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

    @PostMapping("/readUser")
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