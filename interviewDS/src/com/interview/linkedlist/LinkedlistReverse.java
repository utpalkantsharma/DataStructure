package com.interview.linkedlist;

import com.interview.linkedlist.LinkedList.Node;

public class LinkedlistReverse {

	/**
	 * Print LinkedList in reverse order
	 * @param head pointer
	 */
	public void recursive(Node head) {
		if(head == null) return;
		recursive(head.next);
		System.out.println(head.data);
	}
	
	public void recursive(Node head, LinkedList reverse) {
		if(head == null) return;
		recursive(head.next,reverse);
		LinkedList.insert(reverse, head.data);
	}

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList(); 

		LinkedList.insert(list, 1); 
		LinkedList.insert(list, 2);
		LinkedList.insert(list, 3);
		LinkedList.insert(list, 4);
		LinkedList.insert(list, 5);
		LinkedList.insert(list, 6);
		LinkedList.insert(list, 7);
		LinkedList.insert(list, 8);
		LinkedList.insert(list, 9);
		
		LinkedlistReverse reverse = new LinkedlistReverse();
		reverse.recursive(list.head);
		
		LinkedList rev = new LinkedList();
		reverse.recursive(list.head, rev);
		
		LinkedList.printList(rev);

	}

}
