package com.interview.interview.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		/*
		 * List<Employee> emp = new ArrayList<Employee>(); emp.add(new Employee(1,
		 * "ram", 10000, "it")); emp.add(new Employee(2, "mohan", 15000, "operation"));
		 * emp.add(new Employee(3, "krishna", 20000, "it")); emp.add(new Employee(4,
		 * "ravi", 30000, "it"));
		 * 
		 * List<Employee> fileterdList = emp.stream().filter(e -> e.getSalary() > 1500)
		 * .filter(e -> e.getDepartment() == "it").collect(Collectors.toList());
		 * System.out.println(fileterdList);
		 */

		int [] arr = {3,1,5,6,4,8,2};
		String [] str = {};
		Arrays.sort(arr);
		List<Integer> sort = Arrays.stream(arr).boxed().distinct().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(sort.get(2-1));
		Map<Integer, Integer> map = Arrays.stream(arr).boxed().collect(Collectors.toMap(Function.identity(), Function.identity()));
		System.out.println(map);
		map.so
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
	}

}

class ReflectionTest {
	private String wsHostName;
	private int wsPort = 8080;
	private boolean useTestClient = false;

	public ReflectionTest(String wsHostName, int wsPort) {
		this.wsHostName = wsHostName;
		this.wsPort = wsPort;
		this.useTestClient = false;
	}
}

class ThreadTest extends Thread {

	public synchronized void d1() {
		for (int i = 0; i < 500; i++) {
			System.out.println("d1->" + i);
		}
	}

	public synchronized void d2() {
		for (int i = 0; i < 500; i++) {
			System.out.println("d2->" + i);
		}
	}

}

class Employee {
	int id;
	String name;
	float salary;
	String department;

	public Employee(int id, String name, float salary, String department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	}

}
