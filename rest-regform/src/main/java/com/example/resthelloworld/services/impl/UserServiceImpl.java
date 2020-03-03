package com.example.resthelloworld.services.impl;

import com.example.resthelloworld.entity.User;
import com.example.resthelloworld.repository.UserRepository;
import com.example.resthelloworld.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public User editUser(User User) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
