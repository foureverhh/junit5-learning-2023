package com.foureverhh.TddDemo.service;

import com.foureverhh.TddDemo.model.User;
import com.foureverhh.TddDemo.repository.UserRepository;
import com.foureverhh.TddDemo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class TestUserServiceTest {
    UserService userService;
    @Mock
    UserRepository userRepository;
    String firstname;
    String lastname;
    String email;
    String password;
    String repeatPassword;

    @BeforeAll
    void inti() {
        userService = new UserServiceImpl(userRepository);
        firstname ="firstname";
        lastname ="firstname";
        email ="firstname";
        password = "password";
        repeatPassword = "password";
    }
    @Test
    void testCreateUser_whenUserDetailsProvided_returnsUserObject() {
        // Arrange


        // Act
        User user = userService.createUser(firstname, lastname,email, password, repeatPassword);

        // Assert
        assertNotNull(user,"The createUser() should not return null");
    }

    @Test
    void testCreateUser_whenUserCreated_returnUserObjectContainsSameFirstname() {

        // Arrange

        // Act
        User user = userService.createUser(firstname, lastname,email, password, repeatPassword);

        // Assert
        assertEquals(firstname, user.getFirstName(),"User's first should show");
    }

    @DisplayName("Empty first name causes correct exception")
    @Test
    void testCreateUser_whenFirstNameIsEmpty_throwsIllegalArgumentException() {
        // Arrange


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
