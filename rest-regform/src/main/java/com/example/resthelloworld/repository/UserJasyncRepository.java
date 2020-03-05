package com.example.resthelloworld.repository;

import com.example.resthelloworld.entity.User;
import com.github.jasync.sql.db.Connection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserJasyncRepository implements UserRepository{

    @Autowired
    Connection connection;

    public UserJasyncRepository(Connection connection) {
        this.connection = connection;
    }

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
