package com.example.resthelloworld.services;


import com.example.resthelloworld.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface UserService {
    ResponseEntity<User> registerNewAccount(User user);
    List<User> read(Map<String,String> requestParams);
    List<User> readAll();
    User addUser(User user);
    void deleteById(Map<String,String> requestParams);
    User update(String request);

}
