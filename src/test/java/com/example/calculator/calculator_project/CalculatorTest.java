package com.example.calculator.calculator_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import com.example.calculator.Operation;
import com.example.calculator.OperationStrategy;
import com.example.calculator.core.Calculator;
import com.example.calculator.operations.AdditionOperation;
import com.example.calculator.operations.DivisionOperation;
import com.example.calculator.operations.MultiplicationOperation;
import com.example.calculator.operations.SubtractionOperation;

public class CalculatorTest {
	private Calculator calculator;

    @BeforeEach
    void setUp() {
        // Setting up strategies and initializing the Calculator
        Map<Operation, OperationStrategy> strategies = Map.of(
            Operation.ADD, new AdditionOperation(),
            Operation.SUBTRACT, new SubtractionOperation(),
            Operation.MULTIPLY, new MultiplicationOperation(),
            Operation.DIVIDE, new DivisionOperation()
        );

        calculator = new Calculator(strategies);
    }

    @Test
    void testAddition() {
        assertEquals(5.0, calculator.calculate(Operation.ADD, 2, 3), "Addition result is incorrect");
    }

    @Test
    void testSubtraction() {
    	assertEquals(-1.0, calculator.calculate(Operation.SUBTRACT, 2, 3), "Subtraction result is incorrect");
    }

    @Test
    void testMultiplication() {
    	assertEquals(6.0, calculator.calculate(Operation.MULTIPLY, 2, 3), "Multiplication result is incorrect");
    }

    @Test
    void testDivision() {
    	assertEquals(2.0, calculator.calculate(Operation.DIVIDE, 6, 3), "Division result is incorrect");
    }

    @Test
    void testDivisionByZero() {
        calculator.setValue(10);
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.perform(Operation.DIVIDE, 0);
        });
        assertEquals("Division by zero", exception.getMessage(), "Exception message is incorrect");
    }

    @Test
    void testUnsupportedOperation() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            calculator.perform(null, 5);
        });
        assertTrue(exception.getMessage().contains("Operation not supported"), "Unsupported operation error message is incorrect");
    }

    @Test
    void testChainingOperations() {
        calculator.setValue(5)
                .perform(Operation.ADD, 3)
                .perform(Operation.MULTIPLY, 2);
        assertEquals(16.0, calculator.getResult().doubleValue(), "Chaining operations result is incorrect");
    }

    @Test
    void testChainingOperationsWithDifferentOrder() {
        calculator.setValue(10)
                .perform(Operation.SUBTRACT, 5)
                .perform(Operation.ADD, 3)
                .perform(Operation.MULTIPLY, 2)
                .perform(Operation.DIVIDE, 4);
        assertEquals(4.0, calculator.getResult().doubleValue(), "Chaining operations result is incorrect with different order");
    }

    @Test
    void testInitialValueIsZero() {
        assertEquals(0.0, calculator.getResult().doubleValue(), "Initial calculator value should be zero");
    }
}
