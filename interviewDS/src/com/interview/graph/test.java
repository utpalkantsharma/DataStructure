package com.interview.graph;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class test {

	/*
	 * public static void main(String[] args) {
	 * 
	 * List<Rating> ratingList = new ArrayList<Rating>();
	 * ratingList.stream().noneMatch(predicate) Optional<List<Rating>> op =
	 * Optional.ofNullable(ratingList);
	 * 
	 * op.filter(r->r.get(0).getRating().equals("asd")).i
	 * 
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * 
	 * map.put("a", "a string"); map.put("b", "true");
	 * 
	 * boolean v = new Boolean(map.getOrDefault("c", "false").toString());
	 * System.out.println(v);
	 * 
	 * 
	 * List<? super Number> foo3 = new ArrayList<Number>(); // Number is a "super"
	 * of Number List<? super Number> foo4 = new ArrayList<Object>(); // Object is a
	 * "super" of Number
	 * 
	 * 
	 * Optional<String> st = Optional.of(null); Set<Integer> s = new
	 * HashSet<Integer>(); s.add(1); s.add(16); s.add(14); s.add(13); s.add(51);
	 * Iterator<Integer> it = s.iterator(); while (it.hasNext()) {
	 * System.out.println(it.next()); it.remove(); }
	 * 
	 * System.out.println(s);
	 * 
	 * 
	 * List<Byte> list = new ArrayList<>(); List<Integer> list2 = new ArrayList<>();
	 * List<Float> list3 = new ArrayList<>(); List<Double> list4 = new
	 * ArrayList<>(); List<Number> list5 = new ArrayList<>(); c1(list); c1(list2);
	 * c1(list3); c1(list4); c1(list5);
	 * 
	 * List<Number> list1 = new ArrayList<>(); List<Object> list6 = new
	 * ArrayList<>(); c2(list1); c2(list6);
	 * 
	 * Collections.copy(dest, src);
	 * 
	 * 
	 * }
	 */

	/*
	 * public static void c1(List<? extends Integer> a) { // a.add(new Integer(1));
	 * }
	 * 
	 * public static void c2(List<? super Number> a) { a.add(new Integer(1));
	 * 
	 * }
	 */

	/*
	 * public static void main(String[] args) { Scanner inputScanner = new
	 * Scanner(System.in); System.out.printf("Enter a Number:  "); try { int number
	 * = inputScanner.nextInt(); int steps = 0; while (number != 1) { if (number % 2
	 * == 0) { System.out.println(number + " is even, so I take half: " + number /
	 * 2); number /= 2; } else { System.out.println(number +
	 * " is odd, so I make 3n + 1: " + (number * 3 + 1)); number = number * 3 + 1; }
	 * steps++; } System.out.println("The process took " + steps + (steps < 2 ?
	 * " step" : " steps") + " to reach 1"); } catch (Exception e) {
	 * System.out.println(" "); } }
	 */

	/*
	 * public static void main(String[] args) { List<String> l = new
	 * ArrayList<String>(); l.add Map<String, Integer> map = new HashMap<String,
	 * Integer>(); map.put("utpal", 1); map.put("kant", 12); map.put("amit", 30);
	 * 
	 * Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
	 * while(it.hasNext()) { Entry<String, Integer> data = it.next();
	 * System.out.println(data.getKey()+"->"+data.getValue()); }
	 * 
	 * for(Entry<String, Integer> es:map.entrySet())
	 * System.out.println(es.getKey()+" for loop "+es.getValue());
	 * 
	 * map.entrySet().forEach(e->{System.out.println(e.getKey()+"=="+e.getValue());}
	 * );
	 * 
	 * TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(new
	 * SotrByValue()); System.out.println(sortedMap);
	 * 
	 * ConcurrentSkipListMap<String, TreeSet<String>> myDictionary = new
	 * ConcurrentSkipListMap<String, TreeSet<String>>();
	 * 
	 * 
	 * }
	 */

	public static void main(String[] args) {

		/*
		 * int[] arr = {1, 3, 6, 4, 1, 2}; System.out.println(solution( arr));
		 */
		 String s ="aaaa";
		 int [] cost = {3,4,5,6};
		 System.out.println(delete(s, cost));
		/*
		 * String s = "abaac"; int [] cost = {1, 2, 3, 4, 5};
		 * 
		 * System.out.println(minCost(s, cost));
		 */
	}

	private static int minCost(String s, int[] cost) {

		int n = s.length();
		int minCost = 0;

		for (int i = 0; i < n;) {

			int j = i + 1;
			int sum = cost[i];
			int max = cost[i];

			while (j < n && s.charAt(j) == s.charAt(i)) {

				// find max cost from consecutive repeated characters
				max = Math.max(max, cost[j]);

				// calculate total cost for all consecutive characters
				sum += cost[j];
				j++;

			}

			i = j;

			// calculate minimum cost to remove duplicate characters by subtracting max
			// value of duplicate chharacters
			minCost += sum - max;

		}

		return minCost;

	}

	public static int smallest(String s) {
		int counter = 0;

		for (int i = 0; i < s.length(); i++) {

			for (int j = i; j < s.length(); j++) {
				String sub = s.substring(i, j);
				System.out.println(sub);
			}
		}

		return counter;
	}

	public static int delete(String S, int[] C) {
		int result = 0, i = 0;

		for (int j = 1; j < S.length(); j++) {
			if (S.charAt(j) == S.charAt(i)) {
				if (C[j] > C[i]) {
					result += C[i];
					i = j;
				} else
					result += C[j];
			} else
				i = j;
		}

		return result;
	}

	public static int solution(int[] A) {

		List<Integer> l = IntStream.of(A).boxed().distinct().sorted().collect(Collectors.toList());

		System.out.println(l);
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i) != i + 1) {
				return i + 1;
			}
		}

		return 0;
	}
}

class SotrByValue implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}

}

class E1 extends Employee {

	public E1(String name, int age) {
		super(name, age);
	}

}

class Employee implements Cloneable {
	private String name;
	private int age;

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	protected void display() {
		System.out.println("protected method");
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;

		Employee e = (Employee) obj;
		if (name == e.name || name.equals(e.name))
			return true;

		return false;
	}

	@Override
	public int hashCode() {
		return name == null ? 0 : name.hashCode();
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}

class FinalTest {
	public final void thisIsFinalMethod(Callback callback) {
		System.out.println("callback called");
		callback.call("utpal", 10);
	}
}

interface Callback {
	void call(String s, Integer i);
}

class FinalMain {

	void callBackDemo() {
		new FinalTest().thisIsFinalMethod((s, i) -> {
			System.out.println("call back method called s - " + s + ", i - " + i);
		});
	}

}

class Rating {

	String rating;
	String comments;

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rating other = (Rating) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		return true;
	}

}