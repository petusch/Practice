package com.example.resthelloworld;

import java.util.Date;
import java.util.UUID;

public class User {
    private String Name;
    private String Surname;
    private long id; // id requires hashing
    private Date UserCreation;
    private Date BirthDate;
    private String Email;

    public User(){}

    public User(String name, String surname, String email, long birthdate) {
        this.Name = name;
        this.Surname = surname;
        this.Email = email;
        this.BirthDate = new Date(birthdate);
        setId();
        this.UserCreation = new Date();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        this.Surname = surname;
    }

    private void setId() {
        this.id = 1;
    }
    public long getId() {
        return id;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.BirthDate = birthDate;
    }

    public Date getUserCreation() {
        return UserCreation;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

}
