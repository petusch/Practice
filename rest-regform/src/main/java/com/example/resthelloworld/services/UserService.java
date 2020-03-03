package com.example.resthelloworld.services;

import com.example.resthelloworld.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    void delete(long id);
    User editUser(User User);
    List<User> getAll();

}