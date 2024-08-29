# calculator-project

Overview
This project implements a simple and extensible calculator in Java that supports basic arithmetic operations (addition, subtraction, multiplication, division) and allows chaining of multiple operations. The design adheres to key object-oriented principles, including the Open-Closed Principle, and is compatible with an Inversion of Control (IoC) environment for easy testing and dependency management.

Features
Basic Operations: Supports addition, subtraction, multiplication, and division.
Chaining Operations: Allows chaining multiple operations on a single value.
Extensibility: New operations can be added without modifying existing code.
IoC Compatibility: Designed for easy integration with Spring Boot or other IoC frameworks.
Error Handling: Gracefully handles invalid operations and division by zero.
Testing: Unit tests are written for normal and edge cases


SetUp
Download the project form the git repo: https://github.com/SurprisePM/Calculator.git
Export the project to the IDE and build.
junit5, spring-boot-starter are added as dependencies


Explanation of Code
We have an Operation.java file which is an enum which contains the list of operations.
Next we have a functional interface with calculate method.
To achieve Single Responsibility principle and to keep the enum open for modifications, I have created classes for all the operations, and this class implements the above mentioned functional interface.
The Calculator.java is the core class which will utilize a map to associate each Operation with its corresponding OperationStrategy. This allows for easy extensibility and adheres to the Open-Closed Principle. 
CalculatorTest.java contains all the unit tests
AppConfig.java file supports the IOC

>>>>>>> 24642396fcafffd1a1a456bc2950627a6f3c2338
