package com.example.calculator.operations;

import com.example.calculator.OperationStrategy;

public class SubtractionOperation implements OperationStrategy{

	@Override
	public Number calculate(Number num1, Number num2) {
		return num1.doubleValue() - num2.doubleValue();
	}

}
