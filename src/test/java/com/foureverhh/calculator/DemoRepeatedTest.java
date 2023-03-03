package com.foureverhh.calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {
    private Calculator calculator;

    @BeforeEach
    void beforeEachMethod() {
        calculator = new Calculator();
    }
    @RepeatedTest(value = 3, name = "{displayName}, Repetition {currentRepetition} of {totalRepetitions}")
    @DisplayName("Division by Zero")
    void disable_testIntegerDivision_WhenDividendIsDividedByTwo_ShouldThrowArithmeticException(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo) {
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
        // calculator = new Calculator();  //  replace by @BeforeEach
        // Arrange
        int divident = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";

        // Act and Assert
        ArithmeticException actualException = assertThrows(ArithmeticException.class,()->{
            // Act
            calculator.integerDivision(divident,divisor);
        }, "Division by zero should have thrown an Arithmetic exception.");

        // Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Unexpected exception message");
        // fail("Not implemented yet");
    }
}
