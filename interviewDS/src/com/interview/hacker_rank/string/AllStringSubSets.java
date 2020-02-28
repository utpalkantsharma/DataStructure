package com.interview.hacker_rank.string;

public class AllStringSubSets {  
    public static void main(String[] args) {
    	String s1 = "ABCD";
    	//Total n*(n+1)/2 sets will be generated
    	for(int i =0; i<s1.length(); i++) {
    		for(int j=i; j<s1.length(); j++) {
    			System.out.println(s1.substring(i, j+1));
    		}
    	}
    }  
}  