package com.interview.queue;

import java.util.Stack;

/**
 * Implement queue using stack
 * 
 * @author Utpal.Kant
 *
 */
class Queue<E> {

	private Stack<E> stack1;
	private Stack<E> stack2;

	public Queue() {
		this.stack1 = new Stack<E>();
		this.stack2 = new Stack<E>();
	}

	public E dequeue() {
		if (stack1.isEmpty())
			throw new RuntimeException("Queue is empty");
		while (!stack1.isEmpty()) {
			stack2.add(stack1.pop());
		}
		E top = stack2.pop();
		while (!stack2.isEmpty()) {
			stack1.add(stack2.pop());
		}
		return top;
	}

	public void inqueue(E element) {
		System.out.println("Added in queue" + element);
		stack1.add(element);
	}
}

public class QueueUsingStack {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.inqueue(1);
		queue.inqueue(2);
		queue.inqueue(3);
		queue.inqueue(4);

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		queue.inqueue(5);

		System.out.println(queue.dequeue());
	}

}
