package com.foureverhh.TddDemo.service;
import com.foureverhh.TddDemo.model.User;
public interface UserService {
   User createUser(String firstname, String lastname, String email, String password, String repeatPassword);
}
