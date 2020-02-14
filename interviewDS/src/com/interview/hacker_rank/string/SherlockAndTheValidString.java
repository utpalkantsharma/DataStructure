package com.interview.hacker_rank.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
		System.out.println(isValid("a"));
		System.out.println(isValid("aaaabccccdddd"));
		System.out.println(isValid("aabbccddeefghi"));
		System.out.println(isValid("aaabbccddee"));
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
		frequency.entrySet().stream().forEach((entry) -> System.out.print(entry.getKey() + "->" + entry.getValue()));
		List<Integer> list = new ArrayList<>(frequency.values());
		Collections.sort(list);
		int min = list.get(0);
		int max = list.get(list.size() - 1);
		System.out.println("min " + min + ", max " + max);
		if (min == max) {
			return "YES";
		}
		int minMatch = 0;
		int maxMatch = 0;
		for (int i : list) {
			if (i == min) {
				minMatch++;
			} else if (i == max) {
				maxMatch++;
			} else {
				return "NO";
			}
		}
		if ((maxMatch == 1 && max - min == 1) || (minMatch == 1 && min == 1)) {
			return "YES";
		}

		return "NO";
	}

}
