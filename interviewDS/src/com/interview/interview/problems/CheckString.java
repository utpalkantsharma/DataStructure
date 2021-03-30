package com.interview.interview.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class CheckString {

	public static final String OPRNING_BRACES = "{({";
	public static final String CLOSING_BRACES = "])}";

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("somethin");
		list.add("need");
		list.add("tobeadded");
		
		System.out.println(list.size());
		
		List<String> filteredList = list.stream().filter(s -> s.length() >= 5).collect(Collectors.toList());
		System.out.println(filteredList);

		String s = "abcd";
		String s1 = "b";
		System.out.println(s.contains(s1));
		
		System.out.println(isBracesValid(""));

	}
	
	

	public static boolean isBracesValid(String text) {

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < text.length(); i++) {
			if (OPRNING_BRACES.contains(String.valueOf(text.charAt(i)))) {
				stack.push(text.charAt(i));
			} else {
				char pop = stack.pop();
				if (!(pop == text.charAt(i)))
					return false;
			}
		}

		return stack.isEmpty();
	}

}


