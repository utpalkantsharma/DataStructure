package com.interview.stack;

import java.util.Stack;

/**
 * Question: Given an array with a sequence that represents a RPN expression,
 * evaluate the Reverse Polish Notation expression.
 * 
 * Examples:
 * 
 * [ "3", "4", "+", "2", "*", "1", "+" ]
 * 
 * is the same things as ( ( 3 + 4 ) * 2 ) + 1
 * 
 * which is the same things as ( 3 + 4 ) * 2 + 1 because of order of opeartions.
 * 
 * Example 2:
 * 
 * [ "1", "1", "+", "2", "2", "*", "+" ]
 * 
 * @author Utpal.Kant
 *
 */
public class ReversePolishNotation {
	
	public final String operators = "+-*/";
	
	public static void main(String[] args) {
		String [] rpn = {"3", "4", "+", "2", "*", "1", "+"};
		ReversePolishNotation rpnObj = new ReversePolishNotation();
		System.out.println(rpnObj.evaluate(rpn));
	}
	
	public int evaluate(String[] rpn) {
		if (rpn == null || rpn.length < 3)
			throw new IllegalArgumentException("RPN express is not correct.");

		Stack<String> stack = new Stack<String>();
		for (String s : rpn) {
			if (operators.contains(s)) {
				int result = arthematicOperation(Integer.parseInt(stack.pop()), Integer.parseInt(stack.pop()), s);
				stack.push(String.valueOf(result));
			} else {
				stack.push(s);
			}
		}

		return Integer.parseInt(stack.pop());
	}
	
	public int arthematicOperation(int operand1, int operand2, String operator) {
		switch (operator) {
		case "+":
			return operand1 + operand2;
		case "-":
			return operand1 - operand2;
		case "*":
			return operand1 * operand2;
		case "/":
			return operand1 / operand2;
		default:
			throw new IllegalArgumentException(operator + " is not supported");
		}
	}

}
