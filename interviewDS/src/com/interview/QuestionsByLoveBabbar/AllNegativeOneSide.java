package com.interview.QuestionsByLoveBabbar;

import java.util.Arrays;

/**
 * Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
 * Output: -12 -13 -5 -7 -3 -6 11 6 5
 * @author Utpal.Kant
 *
 */
public class AllNegativeOneSide {
	
	public static void main(String[] args) {
		
		int arr[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
		int positiveCounter = 0;
		
		for(int i=0; i< arr.length; i++) {
			
			if(arr[i]<0) {
				//swaping required
				int temp = arr[i];
				arr[i] = arr[positiveCounter];
				arr[positiveCounter] = temp;
				positiveCounter = i;
			}else {
				positiveCounter = i;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
