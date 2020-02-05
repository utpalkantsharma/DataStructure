package com.interview.stack;
/**
 * Implement stack using LinkedList.
 * @author Utpal.Kant
 *
 * @param <E>
 */
public class StackUsingLinkedList<E> {

	private int MAX_SIZE;
	private int size;

	private Node top;

	public StackUsingLinkedList() {
		this(100);
	}

	public StackUsingLinkedList(int maxSize) {
		this.top = null;
		this.MAX_SIZE = maxSize;
		this.size = 0;
	}

	// methods
	public E peep() {
		if (top == null) {
			System.out.println("Stack is empty");
			return null;
		}
		return top.data;
	}

	public void push(E data) {
		if (size() >= MAX_SIZE)
			throw new RuntimeException("Max size reached ");

		Node node = new Node(data);
		node.next = top;
		top = node;
		size++;
		System.out.println("Pushed "+data);
	}

	public E pop() {
		if (top == null)
			throw new RuntimeException("Stack is empty");
		E data = top.data;
		top = top.next;
		size--;
		return data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return size;
	}

	class Node {
		E data;
		Node next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public static void main(String[] args) {
		
		StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<Integer>(10);
		System.out.println(stack.peep());
		
		stack.push(1);
		stack.push(2);
		
		System.out.println("Pop "+stack.pop());
		System.out.println("Isempty "+stack.isEmpty());
		System.out.println("Size "+stack.size());
		
		System.out.println("Pop "+stack.pop());
		System.out.println(stack.pop());
	}

}
