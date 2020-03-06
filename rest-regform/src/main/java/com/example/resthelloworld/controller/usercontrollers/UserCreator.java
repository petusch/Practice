package com.example.resthelloworld.controller.usercontrollers;

import com.example.resthelloworld.entity.User;
import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@RestController
public class UserCreator {


    @Autowired
    Connection connection;

    @RequestMapping(value ={"/testUser", "/createUser"},method = RequestMethod.POST)
    public ResponseEntity<User> user(@RequestBody User user) throws ExecutionException, InterruptedException {


        CompletableFuture<QueryResult> future = connection.sendPreparedStatement("INSERT INTO public.users(\n" +
                "\t name, surname, birthdate, creationDate, eMail)\n" +
                "\tVALUES (\'"+user.getName()+"\',\'"+user.getSurname()+"\',\'"+user.getBirthDate()+ "\',\'"+ user.getUserCreation() +"\',\'"+user.getEmail()+"\');");



        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}