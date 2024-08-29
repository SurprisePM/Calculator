package com.example.calculator.calculator_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.calculator.Operation;
import com.example.calculator.core.Calculator;

@SpringBootApplication(scanBasePackages = "com.example.calculator")
public class App implements CommandLineRunner{
    
	@Autowired
    private Calculator calculator;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
    	Number res1 = calculator.calculate(Operation.ADD, 11, 12);
    	System.out.println("Result: " + res1);
    	
        Number resChain = calculator.setValue(5)
                  .perform(Operation.ADD, 3)
                  .perform(Operation.MULTIPLY, 2)
                  .getResult();

        System.out.println("Result: " + resChain);
    }
    
    
}
