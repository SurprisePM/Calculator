package com.example.calculator.core;

import java.util.*;

import org.springframework.stereotype.Component;

import com.example.calculator.Operation;
import com.example.calculator.OperationStrategy;

@Component
public class Calculator {
	
	//To Map Operations with their corresponding Operational Classes
	private final Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
	private Number currentValue;
	
	//Constructor
    public Calculator(Map<Operation, OperationStrategy> strategies) {
        this.operationStrategyMap.putAll(strategies);
        this.currentValue = 0;
    }

    //To Perform basic calculation operations
    public Number calculate(Operation op, Number num1, Number num2) {
        OperationStrategy strategy = operationStrategyMap.get(op);
        if (strategy == null) {
            throw new UnsupportedOperationException("Operation not supported");
        }
        return strategy.calculate(num1, num2);
    }

    
    //To perform Chaining - Approach(1)
    public Number calculateChaining(Number initial, Object... operations) {
        Number result = initial;
        for (int i = 0; i < operations.length; i += 2) {
            Operation op = (Operation) operations[i];
            Number num = (Number) operations[i + 1];
            result = calculate(op, result, num);
        }
        return result;
    }
    
 
    //To perform Chaining - Approach(2)
    public Calculator setValue(Number value) {
        this.currentValue = value;
        return this;
    }

    
    public Calculator perform(Operation op, Number num) {
        OperationStrategy strategy = operationStrategyMap.get(op);
        if (strategy == null) {
            throw new UnsupportedOperationException("Operation not supported");
        }
        this.currentValue = strategy.calculate(this.currentValue, num);
        return this;
    }

    
    public Number getResult() {
        return this.currentValue;
    }
}
