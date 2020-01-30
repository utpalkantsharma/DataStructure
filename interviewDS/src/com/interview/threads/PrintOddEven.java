package com.interview.threads;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * Prints number from 1 to 10 with help to two threads.
 * Odd and Even thread
 * @author Utpal.Kant
 *
 */
public class PrintOddEven {

	private int printUpTo = 10;

	public static void main(String[] args) {
		PrintOddEven printOddEven = new PrintOddEven();
		AtomicInteger intObj = new AtomicInteger(1);

		Thread oddT1 = new Thread(() -> printOddEven.odd(intObj),"Odd Thread  ");
		Thread evenT2 = new Thread(() -> printOddEven.even(intObj),"Even Thread ");

		oddT1.start();
		evenT2.start();
	}

	public void odd(AtomicInteger aInt) {
		while (printUpTo >= aInt.get()) {
			synchronized (aInt) {
				if (aInt.get() % 2 == 0) {
					try {
						aInt.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println(Thread.currentThread().getName()+aInt.intValue());
					aInt.getAndIncrement();
					aInt.notify();
				}
			}
		}
	}

	public void even(AtomicInteger aInt) {
		while (printUpTo >= aInt.get()) {
			synchronized (aInt) {
				if (aInt.get() % 2 == 0) {
					System.out.println(Thread.currentThread().getName()+aInt.intValue());
					aInt.getAndIncrement();
					aInt.notify();
				} else {
					try {
						aInt.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
