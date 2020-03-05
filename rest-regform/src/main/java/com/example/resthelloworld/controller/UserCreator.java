package com.example.resthelloworld.controller;

import com.example.resthelloworld.entity.User;
import com.example.resthelloworld.services.UserService;
import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.QueryResult;
import com.github.jasync.sql.db.postgresql.PostgreSQLConnectionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@RestController
public class UserCreator {

    @Autowired
    UserService userServices;
    @Autowired
    Connection connection;

    @RequestMapping(value ={"/test", "/create"},method = RequestMethod.POST)
    public ResponseEntity<User> user(@RequestBody User user) throws ExecutionException, InterruptedException {
//        User user = new User();
//
//        String inputJSON = "{ \"name\": \"Oleg\", \"surname\": \"Chernyshow\", \"email\": \"some@gmail.com\", \"birthDate\": 946684800000 }";
//
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            user = mapper.readValue(inputJSON, User.class);
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        //Create User in database
//        System.out.println(user.getEmail());


        CompletableFuture<QueryResult> future = connection.sendPreparedStatement("INSERT INTO public.users(\n" +
                "\t name, surname, birthdate, creationDate, eMail)\n" +
                "\tVALUES (\'"+user.getName()+"\',\'"+user.getSurname()+"\',\'"+user.getBirthDate()+ "\',\'"+ user.getUserCreation() +"\',\'"+user.getEmail()+"\');");

        //System.out.println(future.get());

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}