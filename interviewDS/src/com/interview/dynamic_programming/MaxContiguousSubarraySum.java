package com.interview.dynamic_programming;

public class MaxContiguousSubarraySum {

	public static void main(String[] args) {
		int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(cubicTimeApproach(arr));
	}

	// Brute force approach
	public static int cubicTimeApproach(int arr[]) {
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int tempSum = 0;
				for (int k = i; k <= j; k++) {
					tempSum = tempSum + arr[k];
				}
				if (tempSum > maxSum)
					maxSum = tempSum;

			}
		}
		return maxSum;
	}

	// Dynamic programming
	public static void linearApproach(int arr[]) {

	}

}
