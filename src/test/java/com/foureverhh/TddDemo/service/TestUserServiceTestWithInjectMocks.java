package com.foureverhh.TddDemo.service;

import com.foureverhh.TddDemo.model.User;
import com.foureverhh.TddDemo.repository.UserRepository;
import com.foureverhh.TddDemo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestUserServiceTestWithInjectMocks {
    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UserRepository userRepository;
    String firstname;
    String lastname;
    String email;
    String password;
    String repeatPassword;

    @BeforeEach
    void inti() {
        // userService = new UserServiceImpl(userRepository);
        firstname ="firstname";
        lastname ="firstname";
        email ="firstname";
        password = "password";
        repeatPassword = "password";
    }
    @Test
    void testCreateUser_whenUserDetailsProvided_returnsUserObject() {
        // Arrange
        when(userRepository.save(Mockito.any(User.class))).thenReturn(true);

        // Act
        User user = userService.createUser(firstname, lastname,email, password, repeatPassword);

        // Assert
        assertNotNull(user,"The createUser() should not return null");
    }

    @Test
    void testCreateUser_whenUserCreated_returnUserObjectContainsSameFirstname() {

        // Arrange
        when(userRepository.save(Mockito.any(User.class))).thenReturn(true);
        // Act
        User user = userService.createUser(firstname, lastname,email, password, repeatPassword);

        // Assert
        assertEquals(firstname, user.getFirstName(),"User's first should show");
    }

    @DisplayName("Empty first name causes correct exception")
    @Test
    void testCreateUser_whenFirstNameIsEmpty_throwsIllegalArgumentException() {
        // Arrange
        when(userRepository.save(Mockito.any(User.class))).thenReturn(true);
        Exception exception = assertThrows(IllegalAccessException.class,
                     () -> {
                         // Act
                         userService.createUser(firstname, lastname,email, password, repeatPassword);
                     },
                     "Firstname is empty should throws exceptions");

        // Assert
        assertEquals("Firstname should not empty", exception.getMessage());

    }
}
