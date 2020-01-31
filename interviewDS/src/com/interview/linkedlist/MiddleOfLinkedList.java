package com.interview.linkedlist;

import com.interview.linkedlist.LinkedList.Node;

/**
 * Various ways to find middle of linkedlist
 * 
 * @author Utpal.Kant
 *
 */
public class MiddleOfLinkedList {

	int counter;
	Node midNodeRef;

	public void recursive(Node head) {
		if (head == null) {
			counter = counter / 2;
			return;
		}

		counter++;
		recursive(head.next);

		counter--;
		if (counter == 0)
			midNodeRef = head;
	}

	/**
	 * Taking two pointer slowPointer and fastPointer.
	 * slowPointer will move one step where as fastPointer will move two steps
	 * @param head
	 * @return
	 */
	public Node twoPointers(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}

		Node slowPointer = head;
		Node fastPointer = head;
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer =  slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		return slowPointer;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		LinkedList.insert(list, 1);
		LinkedList.insert(list, 2);
		LinkedList.insert(list, 3);
		LinkedList.insert(list, 4);
		LinkedList.insert(list, 5);

		MiddleOfLinkedList mid = new MiddleOfLinkedList();
		mid.recursive(list.head);
		System.out.println("Middle node using recursive is : " + mid.midNodeRef);
		
		System.out.println("Middle node using twoPointers is : " + mid.twoPointers(list.head));
	}

}
