package com.interview.stack;

import java.util.Deque;
import java.util.LinkedList;
/**
 * Implement stack using {@link Deque}
 * @author Utpal.Kant
 *
 * @param <E>
 */
public class StackUsingDeque<E> {

	private Deque<E> q;

	public StackUsingDeque() {
		q = new LinkedList<E>();
	}

	public E peep() {
		if (q.isEmpty()) {
			System.out.println("Stack is empty, insert few data");
			return null;
		}
		return q.getLast();

	}

	public void push(E data) {
		System.out.println("Push "+data);
		q.addLast(data);
	}

	public E pop() {
		return q.pollLast();
	}

	public boolean isEmpty() {
		return q.isEmpty();
	}

	public int size() {
		return q.size();
	}

	public static void main(String[] args) {

		StackUsingDeque<Integer> stack = new StackUsingDeque<Integer>();
		System.out.println(stack.peep());

		stack.push(1);
		stack.push(2);

		System.out.println("Pop " + stack.pop());
		System.out.println("Isempty " + stack.isEmpty());
		System.out.println("Size " + stack.size());

		System.out.println("Pop " + stack.pop());
		System.out.println(stack.pop());
	}

}
