package com.jennilyn;

import java.util.Stack;

public class Calculator {

    private Stack<Double> stack = new Stack();
    private String[] tokens;

    public Calculator() {
    }

    public double calculate(String input) {

        tokens = input.split(",");

        for(String token : tokens) {

            switch (token){
                case "+":
                    System.out.println("Now adding");
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    System.out.println("Now subtracting");
                    stack.push(-stack.pop() + stack.pop());
                    break;

                case "*":
                    System.out.println("Now multiplying");
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    System.out.println("Now dividing");
                    double divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;

                default:
                    double dToken = Double.parseDouble(token);
                    stack.push(dToken);
                    break;
            }
        }

        return stack.peek();

    }
}
