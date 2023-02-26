package com.foureverhh.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Test Math operations in Calculator class")
class CalculatorTest {

    @Test
            @DisplayName("Test 4/2 = 2")
    //void integerDivision() {
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        Calculator calculator = new Calculator();
        int result = calculator.integerDivision(4,2);
        assertEquals(2, result, "4/2 did not produce 2");
        // fail("should fail");
    }

    @Test
    @DisplayName("Division by Zero")
    void testIntegerDivision_WhenDividendIsDividedByTwo_ShouldThrowArithmeticException() {
        Calculator calculator = new Calculator();
        calculator.integerDivision(4,0);
        fail("Not implemented yet");
    }
    @Test
    @DisplayName("Test 33 - 1 = 32")
    void integerSubtraction() {
        Calculator calculator = new Calculator();
        int result = calculator.integerSubtraction(33, 1);
        assertEquals(32,result);
    }


}