package com.example.resthelloworld;

import java.util.Date;
import java.util.UUID;

public class User {
    private String Name;
    private String Surname;
    private UUID id; // id requires hashing
    private Date UserCreation;
    private Date BirthDate;


    public User(String name, String surname, long birthdate) {
        this.Name = name;
        this.Surname = surname;
        this.BirthDate = new Date(birthdate);
        this.id = UUID.randomUUID();
        this.UserCreation = new Date();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public UUID getId() {
        return id;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public Date getUserCreation() {
        return UserCreation;
    }
}
