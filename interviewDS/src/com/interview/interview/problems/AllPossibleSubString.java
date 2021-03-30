package com.interview.interview.problems;

public class AllPossibleSubString {

	public static void main(String[] args) {
		subString("abc");
	}

	public static void subString(String s) {

		// abc-> a b c ab bc abc
		for (int i = 1; i <= s.length(); i++) {

			for (int j = 0; j < s.length(); j++) {
				if (i + j <= s.length()) {
					System.out.println(s.substring(j, j + i));
				}

			}
		}
	}
}
