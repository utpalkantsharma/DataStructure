package com.interview.linkedlist;

import com.interview.linkedlist.LinkedList.Node;
/**
 * Different ways to reverse linked list.
 * @author Utpal.Kant
 *
 */
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
	
	/**
	 * 1->2->3->4->null
	 * @param head
	 * @return
	 */
	public Node reverse(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node reverseHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		
		return reverseHead;
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
		
		System.out.print("Original list before recursion : ");
		LinkedList.printList(list);
		Node head = reverse.reverse(list.head);
		
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}

	}

}
