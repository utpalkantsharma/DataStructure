package com.interview.QuestionsByLoveBabbar;

public class MaxSubarraySum {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, -2, 5 };
		//int arr[] = { -2, -3, -4, -1, -2, -1, -8, -3 };
		int maxSoFar = arr[0];
		int maxCurrent = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxCurrent = Math.max(maxCurrent + arr[i], arr[i]);
			if (maxCurrent > maxSoFar) {
				maxSoFar = maxCurrent;
			}
		}
		System.out.println("max  - " + maxSoFar);
	}

}
