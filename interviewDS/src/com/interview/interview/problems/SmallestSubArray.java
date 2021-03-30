package com.interview.interview.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SmallestSubArray {

	public static void main(String[] args) {

		String[][] array = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };

		// Java 8
		String[] result = Stream.of(array) // Stream<String[]>
				.flatMap(Stream::of) // Stream<String>
				.toArray(String[]::new);
		Arrays.stream(array).flatMap(s -> Arrays.stream(s)).filter(s -> !s.equals("a")).forEach(System.out::println);
		
		//Reverse string using java 8
		String name = "utpal";
		List<Integer> list = new ArrayList<Integer>();
		list.stream().
		IntStream stream = IntStream.of(2, 4, 6, -2, -4);
		stream.s
	}

	private static int findSmallest(int[] arr, int x) {

		return 1;
	}

}
