package com.foureverhh.tests_in_one_class.ordered_order;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class )
public class MethodOrderedNameTest {
    @Test
    void testC() {
        System.out.println("Running test C");
    }

    @Test
    void testA() {
        System.out.println("Running test A");
    }

    @Test
    void testD() {
        System.out.println("Running test D");
    }

    @Test
    void testB() {
        System.out.println("Running test B");
    }
}
