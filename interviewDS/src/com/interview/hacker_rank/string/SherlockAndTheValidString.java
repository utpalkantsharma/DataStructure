package com.interview.hacker_rank.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Sherlock considers a string to be valid if all characters of the string
 * appear the same number of times. It is also valid if he can remove just 1
 * character at index 1 in the string, and the remaining characters will occur
 * the same number of times. Given a string s, determine if it is valid. If so,
 * return YES, otherwise return NO.
 * 
 * @author Utpal.Kant
 *
 */
public class SherlockAndTheValidString {

	public static void main(String[] args) {
		System.out.println(isValid("aabbccddeefghi"));
	}

	// Complete the isValid function below.
	static String isValid(String s) {
		Map<Character, Integer> frequency = new HashMap<Character, Integer>();

		for (char c : s.toCharArray()) {
			if (!frequency.containsKey(c)) {
				frequency.computeIfAbsent(c, v -> 1);
			} else {
				frequency.compute(c, (k, v) -> ++v);
			}
		}
		frequency.entrySet().stream().forEach((entry) -> System.out.println(entry.getKey() + "->" + entry.getValue()));
		int count = 0;
		int allowedRemoval = 0;
		for (Map.Entry<Character, Integer> e : frequency.entrySet()) {
			if (count == 0) {
				count = e.getValue();
				continue;
			}
			if (e.getValue() == count + 1 || e.getValue() + 1 == count) {
				allowedRemoval++;
			} else if (e.getValue() - count > 1 || count - e.getValue() > 1) {
				return "NO";
			}
		}
		return (allowedRemoval == 1 || allowedRemoval == 0) ? "YES" : "NO";
	}

}
