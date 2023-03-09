package com.foureverhh.TddDemo.model;

import lombok.Data;

import java.util.UUID;
@Data
public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String repeatedPassword;


    private String id;

    public User() {
    }

    public User(String firstname, String lastname, String email, String password, String repeatedPassword) {
        this.id = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                ", id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", repeatedPassword='" + repeatedPassword + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstname;
    }
}
