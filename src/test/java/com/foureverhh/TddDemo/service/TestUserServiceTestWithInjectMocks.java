package com.foureverhh.TddDemo.service;

import com.foureverhh.TddDemo.exception.EmailNotificationException;
import com.foureverhh.TddDemo.exception.UserServiceException;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestUserServiceTestWithInjectMocks {
    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UserRepository userRepository;
    @Mock
    EmailVerificationService emailVerificationService;
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
        when(userRepository.save(any(User.class))).thenReturn(true);

        // Act
        User user = userService.createUser(firstname, lastname,email, password, repeatPassword);

        // Assert
        assertNotNull(user,"The createUser() should not return null");
    }

    @Test
    void testCreateUser_whenUserCreated_returnUserObjectContainsSameFirstname() {

        // Arrange
        when(userRepository.save(any(User.class))).thenReturn(true);
        // Act
        User user = userService.createUser(firstname, lastname,email, password, repeatPassword);

        // Assert
        assertEquals(firstname, user.getFirstName(),"User's first should show");
    }

    @DisplayName("Empty first name causes correct exception")
    @Test
    void testCreateUser_whenFirstNameIsEmpty_throwsIllegalArgumentException() {
        // Arrange
        firstname = "";
        Exception exception = assertThrows(IllegalAccessException.class,
                     () -> {
                         // Act
                         userService.createUser(firstname, lastname,email, password, repeatPassword);
                     },
                     "Firstname is empty should throws exceptions");

        // Assert
        assertEquals("Firstname should not empty", exception.getMessage());

    }

    @Test
    void testCreateUser_whenSaveMethodThrowsException_thenThrowsUserServiceException() {
        // Arrange
        Mockito.when(userRepository.save(any(User.class))).thenThrow(RuntimeException.class);
        // Act
         assertThrows(UserServiceException.class, ()->{
            userService.createUser(firstname,lastname,email,password,repeatPassword);
        }, "should throw UserServiceException");
        // Assert

        // assertEquals(e.getMessage(),"Could not create user");
    }

    @Test
    @DisplayName("email exception is handled")
    void testCreatUser_whenEmailNotificationExceptionThrown_throwsEmailException() {
        when(userRepository.save(any(User.class))).thenReturn(true);
        // whenThrow works only to methods with return types
        // when(emailVerificationService.scheduledEmailConfirmation(Mockito.any(User.class))).thenThrow();
        // arrange for void method
        doThrow(EmailNotificationException.class).when(emailVerificationService).scheduledEmailConfirmation(any(User.class));

        Exception e = assertThrows(EmailNotificationException.class, ()->{
            userService.createUser(firstname,lastname,email,password,repeatPassword);
        },"email exception not handled");

        assertEquals("Could not send email", e.getMessage());
        verify(userRepository, times(1)).save(any(User.class));
        verify(emailVerificationService, Mockito.atLeastOnce()).scheduledEmailConfirmation(any(User.class));
    }

    @Test
    @DisplayName("No email exception is handled")
    void testCreatUser_whenEmailNotificationExceptionNotThrown_throwsUserServiceException() {
        when(userRepository.save(any(User.class))).thenThrow(RuntimeException.class);
        // whenThrow works only to methods with return types
        // when(emailVerificationService.scheduledEmailConfirmation(Mockito.any(User.class))).thenThrow();
        // arrange for void method throw exception
        // doThrow(EmailNotificationException.class).when(emailVerificationService).scheduledEmailConfirmation(any(User.class));
        // arrange for void method do nothing
        doNothing().when(emailVerificationService).scheduledEmailConfirmation(any(User.class));
        Exception e = assertThrows(EmailNotificationException.class, ()->{
            userService.createUser(firstname,lastname,email,password,repeatPassword);
        },"email exception not handled");

        assertEquals("Could not send email", e.getMessage());
        verify(userRepository, times(1)).save(any(User.class));
        verify(emailVerificationService, Mockito.atLeastOnce()).scheduledEmailConfirmation(any(User.class));
    }
}
