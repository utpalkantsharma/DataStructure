package com.interview.interview.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByKeyByVlaue {
	
	public static void main(String[] args) {
		int arr[] = {7, 10, 4, 20, 15};
		
		System.out.println(kthSmallest(arr, 0, 5, 4));
	}
	
	public static int kthSmallest(int[] arr, int l, int r, int k) 
	{ 
	    //Your code here
	    List<Integer> list = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
	    return list.get(k-1);
	} 
	

}
