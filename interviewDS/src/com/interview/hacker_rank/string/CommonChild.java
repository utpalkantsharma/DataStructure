package com.interview.hacker_rank.string;

import java.util.Arrays;

/**
 * A string is said to be a child of a another string if it can be formed by
 * deleting 0 or more characters from the other string. Given two strings of
 * equal length, what's the longest string that can be constructed such that it
 * is a child of both?
 * 
 * For example, ABCD and ABDC have two children with maximum length 3, ABC and
 * ABD. They can be formed by eliminating either the D or C from both strings.
 * Note that we will not consider ABCD as a common child because we can't
 * rearrange characters and ABCD != ABDC.
 * 
 * Function Description
 * 
 * Complete the commonChild function in the editor below. It should return the
 * longest string which is a common child of the input strings.
 * 
 * commonChild has the following parameter(s):
 * 
 * s1, s2: two equal length strings
 * 
 * @author Utpal.Kant
 *
 */
public class CommonChild {

	public static void main(String[] args) {
		
		//Expected output 3
		System.out.println(lcsDynamic("SHINCHAN".toCharArray(), "NOHARAAA".toCharArray()));
		System.out.println(lcsRecursive("SHINCHAN".toCharArray(), "NOHARAAA".toCharArray(), "SHINCHAN".length(),
				"NOHARAAA".length()));
		
		String s1 = "WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS";
		String s2 = "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC";
		//Expected output 15
		System.out.println(lcsDynamic(s1.toCharArray(),s2.toCharArray()));
		//System.out.println(lcsRecursive(s1.toCharArray(),s2.toCharArray(),s1.length(),s2.length()));

	}

	public static int lcsDynamic(char str1[], char str2[]) {

		int temp[][] = new int[str1.length + 1][str2.length + 1];
		int max = 0;

		for (int i = 1; i < temp.length; i++) {
			for (int j = 1; j < temp[i].length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					temp[i][j] = temp[i - 1][j - 1] + 1;
				} else {
					temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]);
				}
				if (temp[i][j] > max) {
					max = temp[i][j];
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				System.out.print(temp[i][j]);
			}
			System.out.println();
		}
		return max;

	}

	public static int lcsRecursive(char str1[], char str2[], int l1, int l2) {
		if (l1 == 0 || l2 == 0)
			return 0;

		if (str1[l1 - 1] == str2[l2 - 1]) {
			return 1 + lcsRecursive(str1, str2, l1 - 1, l2 - 1);
		} else {
			return Math.max(lcsRecursive(str1, str2, l1 - 1, l2), lcsRecursive(str1, str2, l1, l2 - 1));
		}
	}

}
