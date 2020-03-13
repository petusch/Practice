package com.example.resthelloworld.entity;

import org.joda.time.LocalDateTime;

import java.util.Date;

public class User {


    private String Name;


    private String password;
    private String Surname;
    private Date UserCreation;
    private Date BirthDate;
    private String Email;

    public User()
    {
        this.UserCreation = new Date();
    }

    public User(String name, String surname, String email, long birthdate) {
        this.Name = name;
        this.Surname = surname;
        this.Email = email;
        this.BirthDate = new Date(birthdate);
        this.UserCreation = new Date();
    }


    public User(String name, String surname, String email) {
        this.Name = name;
        this.Surname = surname;
        this.Email = email;
        this.UserCreation = new Date();
    }


    public User(String name, String surname, String email, LocalDateTime birthdate, LocalDateTime creationdate) {
        this.Name = name;
        this.Surname = surname;
        this.Email = email;
        this.UserCreation = creationdate.plusDays(1).toDate();
        this.BirthDate = birthdate.plusDays(1).toDate();
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString()
    {
        return "["+ Name + " | " + Surname + " | " + Email + " | " + BirthDate + " | " + UserCreation +"]" ;
    }

}
