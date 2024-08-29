package com.example.calculator.calculator_project.operations;

public class DivisionOperation implements OperationStrategy{

	@Override
	public Number calculate(Number num1, Number num2) {
		if (num2.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return num1.doubleValue() / num2.doubleValue();
	}

}
