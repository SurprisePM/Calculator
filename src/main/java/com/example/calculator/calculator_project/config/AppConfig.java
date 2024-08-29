package com.example.calculator.calculator_project.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.calculator.calculator_project.core.Calculator;
import com.example.calculator.calculator_project.operations.AdditionOperation;
import com.example.calculator.calculator_project.operations.DivisionOperation;
import com.example.calculator.calculator_project.operations.MultiplicationOperation;
import com.example.calculator.calculator_project.operations.Operation;
import com.example.calculator.calculator_project.operations.OperationStrategy;
import com.example.calculator.calculator_project.operations.SubtractionOperation;

@Configuration
public class AppConfig {
	@Bean
    public Calculator calculator() {
        return new Calculator(Map.of(
            Operation.ADD, addOperation(),
            Operation.SUBTRACT, subtractOperation(),
            Operation.MULTIPLY, multiplyOperation(),
            Operation.DIVIDE, divideOperation()
        ));
    }

    @Bean
    public OperationStrategy addOperation() {
        return new AdditionOperation();
    }

    @Bean
    public OperationStrategy subtractOperation() {
        return new SubtractionOperation();
    }

    @Bean
    public OperationStrategy multiplyOperation() {
        return new MultiplicationOperation();
    }

    @Bean
    public OperationStrategy divideOperation() {
        return new DivisionOperation();
    }
}
