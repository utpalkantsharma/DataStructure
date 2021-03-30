package com.interview.interview.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and an array of integers cost where cost[i] is the cost of
 * deleting the ith character in s.
 * 
 * Return the minimum cost of deletions such that there are no two identical
 * letters next to each other.
 * 
 * Notice that you will delete the chosen characters at the same time, in other
 * words, after deleting a character, the costs of deleting other characters
 * will not change.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abaac", cost = [1,2,3,4,5] Output: 3 Explanation: Delete the
 * letter "a" with cost 3 to get "abac" (String without two identical letters
 * next to each other).
 * 
 * 
 * Example 2:
 * 
 * Input: s = "abc", cost = [1,2,3] Output: 0 Explanation: You don't need to
 * delete any character because there are no identical letters next to each
 * other.
 * 
 * 
 * Example 3:
 * 
 * Input: s = "aabaa", cost = [1,2,3,4,1] Output: 2 Explanation: Delete the
 * first and the last character, getting the string ("aba").
 * 
 * 
 * @author Utpal.Kant
 *
 */
public class MinumCostToDelete {

	public static void main(String[] args) {
		String s = "abaac";
		int[] cost = { 1, 2, 3, 4, 5 };
		System.out.println(delete(s, cost));
	}

	private static int delete(String s, int[] cost) {
		Set<Character> visited = new HashSet<Character>();

		int result = 0;

		for (int i = 0; i < s.length(); i++) {

			if (visited.contains(s.charAt(i)))
				continue;
			else
				visited.add(s.charAt(i));
			int lastMin = cost[i];
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (lastMin < cost[j]) {
						result += lastMin;
						lastMin = cost[j];
					}else {
						lastMin = cost[j];
						result += lastMin;
					}
				}
			}
		}

		return result;
	}
}
