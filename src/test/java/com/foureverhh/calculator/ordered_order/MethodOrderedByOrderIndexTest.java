package com.foureverhh.calculator.ordered_order;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class )
public class MethodOrderedByOrderIndexTest {
    @Test
    @Order(3)
    void testC() {
        System.out.println("Running test C");
    }

    @Test
    @Order(2)
    void testA() {
        System.out.println("Running test A");
    }

    @Test
    @Order(1)
    void testD() {
        System.out.println("Running test D");
    }

    @Test
    @Order(4)
    void testB() {
        System.out.println("Running test B");
    }
}
