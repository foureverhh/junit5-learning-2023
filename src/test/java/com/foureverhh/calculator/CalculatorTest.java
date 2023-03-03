package com.foureverhh.calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Test Math operations in Calculator class")
class CalculatorTest {
    private Calculator calculator;
    @BeforeAll
    static void setup() {
        System.out.println("Executing @BeforeAll method.");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Executing @AfterAll method");
    }

    @BeforeEach
    void beforeEachTestMethod() {
        calculator = new Calculator();
        System.out.println("Executing @BeforeEach method");
    }

    @AfterEach
    void afterEachTestMethod() {
        System.out.println("Executing @AfterEach method");
    }
    @Test
    @DisplayName("Test 4/2 = 2")
    //void integerDivision() {
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        System.out.println("Test 4/2=2");
        //Arrange  //Given
        // calculator = new Calculator(); //  replace by @BeforeEach
        //Act      //When
        int result = calculator.integerDivision(4,2);
        //Assert   //Then
        assertEquals(2, result, "4/2 did not produce 2");
        // fail("should fail");
    }

    //@Test
    @DisplayName("Division by Zero")
    void testIntegerDivision_WhenDividendIsDividedByTwo_ShouldThrowArithmeticException() {
        System.out.println("Division by Zero");
        // calculator = new Calculator();  //  replace by @BeforeEach
        calculator.integerDivision(4,0);
        fail("Not implemented yet");
    }
    // @Disabled("The reason to disable unit test")
    @Test
    @DisplayName("Division by Zero")
    void disable_testIntegerDivision_WhenDividendIsDividedByTwo_ShouldThrowArithmeticException() {
        System.out.println("Division by Zero");
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
    @Test
    @DisplayName("Test 33 - 1 = 32")
    void integerSubtraction() {
        System.out.println("Test 33 - 1 = 32");
        //calculator = new Calculator(); //  replace by @BeforeEach
        int result = calculator.integerSubtraction(33, 1);
        assertEquals(32,result);
    }


}