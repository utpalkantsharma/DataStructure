package com.interview.problems;
/**
 * Print all possible brackets.
 * @author Utpal.Kant
 *
 */
public class BalancedBrackets {

	// 4,4
	public static void balance(String s, int lCount, int rCount) {

		if (lCount == 0 && rCount == 0) {
			System.out.println(s);
			return;
		}

		if (lCount > 0) {
			balance(s + "(", lCount-1, rCount);
		}

		if (lCount < rCount) {

			balance(s + ")", lCount, rCount - 1);
		}
		return;

	}

	public static void main(String[] args) {
		int numberOfBraces = 4;
		balance("", numberOfBraces, numberOfBraces);
	}

}
