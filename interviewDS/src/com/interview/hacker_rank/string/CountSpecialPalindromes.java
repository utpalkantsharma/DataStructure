package com.interview.hacker_rank.string;

import java.util.Arrays;

/**
 * Given a String s, count all special palindromic substrings of size greater
 * than 1. A Substring is called special palindromic substring if all the
 * characters in the substring are same or only the middle character is
 * different for odd length. Example “aabaa” and “aaa” are special palindromic
 * substrings and “abcba” is not special palindromic substring.
 * 
 * Examples :
 * 
 * Input : str = " abab" Output : 2 All Special Palindromic substring are:
 * "aba", "bab"
 * 
 * Input : str = "aabbb" Output : 4 All Special substring are: "aa", "bb",
 * "bbb", "bb"
 * 
 * @author Utpal.Kant
 *
 */
public class CountSpecialPalindromes {

	public static void main(String[] args) {
		String word = "aabaa";
		System.out.println(Arrays.toString(frequencyOfChar(word)));
		System.out.println(countSepcialPalindrome(word));
	}

	public static int countSepcialPalindrome(String word) {
		int[] frequency = frequencyOfChar(word);
		int count = 0;
		for (int i = 1; i < frequency.length; i++) {
			if (i < frequency.length - 1 && frequency[i - 1] != frequency[i] && frequency[i - 1] == frequency[i + 1]) {
				count = count + Math.min(frequency[i - 1], frequency[i + 1]);
			}
		}
		return count;
	}

	public static int[] frequencyOfChar(String word) {
		int freq[] = new int[word.length()];
		int startingPointer = 0;
		char pervious = word.charAt(0);
		int frequency = 1;
		for (int i = 1; i < word.length(); i++) {
			if (pervious == word.charAt(i)) {
				frequency++;
				if (i == word.length() - 1) {
					while (startingPointer <= i) {
						freq[startingPointer++] = frequency;
					}
				}
			} else {
				while (startingPointer < i) {
					freq[startingPointer++] = frequency;
				}
				frequency = 1;
				startingPointer = i;
			}
			pervious = word.charAt(i);
		}
		if (freq[freq.length - 1] == 0) {
			freq[freq.length - 1] = frequency;
		}
		return freq;
	}

}
