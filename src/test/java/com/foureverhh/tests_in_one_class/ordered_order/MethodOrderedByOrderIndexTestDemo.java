package com.foureverhh.tests_in_one_class.ordered_order;

import com.foureverhh.model.User;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class )
public class MethodOrderedByOrderIndexTestDemo {
    private Map<String,User> userMap;

    @BeforeAll
    void setup() {
        userMap = new HashMap<>();
    }

    StringBuilder completed = new StringBuilder("");
    @AfterEach
    void afterEach() {
        System.out.println("Map is " + userMap);
        System.out.println("The state of instance object is " + completed);
    }
    @Test
    @DisplayName("Find user works")
    @Order(3)
    void testC() {
        System.out.println("Running test C");
        completed.append("3");
        System.out.println("user found " + userMap.get("user"));
        assertEquals("updated user", userMap.get("user").getName(), "should return name as updated user");
    }

    @Test
    @DisplayName("Update user works")
    @Order(2)
    void testA() {
        System.out.println("Running test A");
        completed.append("2");
        User user = userMap.get("user");
        user.setName("updated user");
        userMap.put("user", user);
    }

    @Test
    @Order(1)
    @DisplayName("Create user works")
    void testD() {
        System.out.println("Running test D");
        completed.append("1");
        userMap.put("user", new User(1, "user"));
    }

    @Test
    @Order(4)
    @DisplayName("Delete user works")
    void testB() {
        System.out.println("Running test B");
        completed.append("4");
        userMap.put("user",null);
        assertNull(userMap.get("user"));
    }
}
