package com.interview.linkedlist;

import com.interview.linkedlist.LinkedList.Node;
/**
 * Merge two sorted linked list.
 * @author Utpal.Kant
 *
 */
public class MergeSortedLinkedList {

	public Node merge(Node head1, Node head2) {

		Node previous = head1;
		Node current = head1;
		Node secondPointer = head2;

		while (current != null && secondPointer != null) {

			if (current.data > secondPointer.data) {
				previous.next = secondPointer;
				Node temp = secondPointer.next;
				secondPointer.next = current;
				secondPointer = temp;
				//
				current = previous.next;
			} else {
				previous = current;
				current = current.next;
			}
		}
		if (secondPointer != null) {
			previous.next = secondPointer;
		}

		return head1;
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		LinkedList.insert(list1, 2);
		LinkedList.insert(list1, 5);
		LinkedList.insert(list1, 6);
		LinkedList.insert(list1, 9);

		LinkedList list2 = new LinkedList();
		LinkedList.insert(list2, 3);
		LinkedList.insert(list2, 7);
		LinkedList.insert(list2, 18);

		MergeSortedLinkedList merge = new MergeSortedLinkedList();
		Node head = null;
		if (list1.head.data < list2.head.data) {
			head = merge.merge(list1.head, list2.head);
		} else {
			head = merge.merge(list2.head, list1.head);
		}

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}

}
