package com.foureverhh.TddDemo.service.impl;

import com.foureverhh.TddDemo.exception.EmailNotificationException;
import com.foureverhh.TddDemo.exception.UserServiceException;
import com.foureverhh.TddDemo.model.User;
import com.foureverhh.TddDemo.repository.UserRepository;
import com.foureverhh.TddDemo.service.EmailVerificationService;
import com.foureverhh.TddDemo.service.UserService;
import lombok.SneakyThrows;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    EmailVerificationService emailVerificationService;

    public UserServiceImpl(UserRepository userRepository, EmailVerificationService emailVerificationService) {
        this.userRepository = userRepository;
        this.emailVerificationService = emailVerificationService;
    }

    @SneakyThrows
    @Override
    public User createUser(String firstname, String lastname, String email, String password, String repeatPassword) {

        if (firstname.trim().length() == 0) {
            throw new IllegalAccessException("Firstname should not empty");
        }

        User user = new User(firstname, lastname, email, password, repeatPassword);

        boolean result;
        try {
           result =  userRepository.save(user);
        }catch (RuntimeException e) {
            throw new UserServiceException(e.getMessage());
        }
        if(!result) {
            throw new UserServiceException("Could not create user");
        }

        try {
            emailVerificationService.scheduledEmailConfirmation(user);
        }catch (RuntimeException e) {
            throw new EmailNotificationException("Could not send email");
        }
        return user;
    }
}
