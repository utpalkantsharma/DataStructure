package com.interview.linkedlist;

import com.interview.linkedlist.LinkedList.Node;

/**
 * Given two LinkedList, add each node value. 
 * Example: 
 *          L1 -> 1 1 0 1 
 *          L2 ->   1 0 0
 * Output list -> 1 2 0 1
 * 
 * @author Utpal.Kant
 *
 */
public class AddLinkedList {

	public void recursive(Node head, LinkedList reverse) {
		if (head == null) return;
		recursive(head.next, reverse);
		LinkedList.insert(reverse, head.data);
	}

	public LinkedList add(Node head1, Node head2) {
		LinkedList result = new LinkedList();
		int carry = 0;
		while (head1 != null || head2 != null) {
			if (head1 != null && head2 != null) {
				int sum = head1.data + head2.data;
				int value = sum > 9 ? sum % 10 : sum;
				LinkedList.insert(result, value + carry);
				carry = sum > 9 ? 1 : 0;
				head1 = head1.next;
				head2 = head2.next;
			} else if (head1 != null && head2 == null) {
				LinkedList.insert(result, head1.data);
				head1 = head1.next;
			} else {
				LinkedList.insert(result, head2.data);
				head2 = head2.next;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		LinkedList list1 = new LinkedList();
		LinkedList.insert(list1, 1);
		LinkedList.insert(list1, 1);
		LinkedList.insert(list1, 0);
		LinkedList.insert(list1, 9);

		LinkedList list2 = new LinkedList();
		LinkedList.insert(list2, 1);
		LinkedList.insert(list2, 2);
		LinkedList.insert(list2, 6);

		LinkedList rList1 = new LinkedList();
		LinkedList rList2 = new LinkedList();

		AddLinkedList obj = new AddLinkedList();
		obj.recursive(list1.head, rList1);
		obj.recursive(list2.head, rList2);
		
		LinkedList result = obj.add(rList1.head, rList2.head);
		LinkedList rResult = new LinkedList();
		
		obj.recursive(result.head, rResult);
		LinkedList.printList(rResult);

	}
}
