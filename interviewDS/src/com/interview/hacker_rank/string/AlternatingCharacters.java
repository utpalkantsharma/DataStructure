package com.interview.hacker_rank.string;

/**
 * You are given a string containing characters A and B only. Your task is to
 * change it into a string such that there are no matching adjacent characters.
 * To do this, you are allowed to delete zero or more characters in the string.
 * 
 * Your task is to find the minimum number of required deletions.
 * 
 * Sample Input
 * 
 * 5 AAAA BBBBB ABABABAB BABABA AAABBB
 * 
 * Sample Output
 * 
 * 3 4 0 0 4
 * 
 * @author Utpal.Kant
 *
 */
public class AlternatingCharacters {

	public static void main(String[] args) {
		System.out.println(alternatingCharacters("AAAA"));
		System.out.println(alternatingCharacters("BBBBB"));
		System.out.println(alternatingCharacters("ABABABAB"));
		System.out.println(alternatingCharacters("BABABA"));
		System.out.println(alternatingCharacters("AAABBB"));
	}

	// Complete the alternatingCharacters function below.
	static int alternatingCharacters(String s) {

		char perviousChar = s.charAt(0);
		int counter = 0;
		for (int i = 1; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if (perviousChar == currentChar) {
				counter++;
			}
			perviousChar = currentChar;
		}
		return counter;
	}

}
