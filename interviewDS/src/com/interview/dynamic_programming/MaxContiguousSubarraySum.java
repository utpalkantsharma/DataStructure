package com.interview.dynamic_programming;

import java.util.Arrays;

public class MaxContiguousSubarraySum {

	public static void main(String[] args) {
		int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(cubicTimeApproach(arr));
		System.out.println(linearApproach(arr));
	}

	// Brute force approach
	// n(n+1)/2 = 9(10)/2 = 45 combinations
	public static int cubicTimeApproach(int arr[]) {
		int maxSum = Integer.MIN_VALUE;
		int temp[] = new int[(arr.length * (arr.length + 1)) / 2];
		int counter = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int tempSum = 0;
				for (int k = i; k <= j; k++) {
					tempSum = tempSum + arr[k];
				}
				temp[counter++] = tempSum;
				maxSum = Math.max(tempSum, maxSum);
			}
		}

		System.out.println("Total Combination's = " + temp.length);
		System.out.println(Arrays.toString(temp));
		return maxSum;
	}

	// Dynamic programming
	public static int linearApproach(int arr[]) {
		int sumArr[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				sumArr[i] = arr[i];
			} else {
				sumArr[i] = Math.max(arr[i], sumArr[i - 1] + arr[i]);
			}
		}
		
		return Arrays.stream(sumArr).max().getAsInt();

	}

}
