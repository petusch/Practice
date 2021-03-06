package com.example.resthelloworld.controller.usercontrollers;

import com.example.resthelloworld.entity.User;
import com.example.resthelloworld.services.UserService;
import com.github.jasync.sql.db.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;



@RestController
public class UserCreator {


    @Autowired
    Connection connection;

    @Resource
    UserService userService;

    @RequestMapping(value ={"testUser", "/createUser"},method = RequestMethod.POST)
    public ResponseEntity<User> user(@RequestBody User user){



        userService.registerNewAccount(user);



        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
