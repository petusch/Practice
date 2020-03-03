package com.example.resthelloworld.repository;

import com.example.resthelloworld.entity.User;
import com.github.jasync.sql.db.Connection;

import java.util.List;

public class UserJasyncRepository implements UserRepository{


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
