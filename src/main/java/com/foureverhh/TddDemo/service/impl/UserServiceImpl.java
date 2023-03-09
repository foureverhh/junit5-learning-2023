package com.foureverhh.TddDemo.service.impl;

import com.foureverhh.TddDemo.exception.UserServiceException;
import com.foureverhh.TddDemo.model.User;
import com.foureverhh.TddDemo.repository.UserRepository;
import com.foureverhh.TddDemo.service.UserService;
import lombok.SneakyThrows;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @SneakyThrows
    @Override
    public User createUser(String firstname, String lastname, String email, String password, String repeatPassword) {

        if (firstname.trim().length() == 0) {
            throw new IllegalAccessException("Firstname should not empty");
        }
        User user = new User(firstname, lastname, email, password, repeatPassword);
        boolean result = userRepository.save(user);
        if(!result) {
            throw new UserServiceException("Could not create user");
        }
        return user;
    }
}
