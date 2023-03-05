package com.foureverhh.tests_in_one_class.ordered_order;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class )
public class MethodOrderedByOrderIndexTestPerClass {
    StringBuilder completed = new StringBuilder("");
    @AfterEach
    void afterEach() {
        System.out.println("The state of instance object is " + completed);
    }
    @Test
    @Order(3)
    void testC() {
        System.out.println("Running test C");
        completed.append("3");
    }

    @Test
    @Order(2)
    void testA() {
        System.out.println("Running test A");
        completed.append("2");
    }

    @Test
    @Order(1)
    void testD() {
        System.out.println("Running test D");
        completed.append("1");
    }

    @Test
    @Order(4)
    void testB() {
        System.out.println("Running test B");
        completed.append("4");
    }
}
