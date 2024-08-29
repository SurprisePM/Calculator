package com.example.calculator.calculator_project.operations;

public class MultiplicationOperation implements OperationStrategy{

	@Override
	public Number calculate(Number num1, Number num2) {
		return num1.doubleValue() * num2.doubleValue();
	}

}
