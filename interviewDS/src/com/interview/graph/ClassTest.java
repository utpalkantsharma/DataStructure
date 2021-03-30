package com.interview.graph;

import java.lang.reflect.Field;

public class ClassTest {
	

	public static void main(String[] args) {
		ThreadTest1 t1 = new ThreadTest1();
		Thread t = new Thread(t1);
		
		ThreadTest2 t2 = new ThreadTest2();
		
		t.start();
		t2.start();
	}

	

}

interface I{
	public static String name() {
		return "utpal";
	}
	
	public default String des() {
		return "se";
	}
}

class Impl implements I{
	@Override
	public   String des() {
		return "utpal";
	}
}

class ThreadTest1 implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}

class ThreadTest2 extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
}