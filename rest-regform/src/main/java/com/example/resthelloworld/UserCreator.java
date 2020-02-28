package com.example.resthelloworld;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserCreator {



    @RequestMapping(value ={"/test", "/create"},method = RequestMethod.POST)
    public ResponseEntity<User> user(@RequestBody User user) {
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
        System.out.println(user.getEmail());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}