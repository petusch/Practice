package com.example.resthelloworld.repository;

import com.example.resthelloworld.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository  {
    User addUser(User user);
    void delete(long id);
    User editUser(User User);
    List<User> getAll();

}
