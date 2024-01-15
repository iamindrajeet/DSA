package linkedList;

import java.util.HashSet;
import java.util.Set;

public class Questions {
	// remove duplicates from linked list
	public void deleteDuplicates(LinkedList linkedList) {
		Set<Integer> set = new HashSet<>();
		Node current = linkedList.head;
		Node prev = null;
		while (current != null) {
			if (!set.contains(current.value)) {
				set.add(current.value);
				prev = current;
			} else {
				prev.next = current.next;
				linkedList.size--;
			}
			current = current.next;
		}
	}

	// return the node in nth position from last
	public Node nthToLast(LinkedList linkedList, int n) {
		Node p1 = linkedList.head;
		Node p2 = linkedList.head;
		for (int i = 0; i < n - 1; i++) {
			if (p2 == null)
				return null;
			p2 = p2.next;
		}
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	// partition - write a code to partition a LL around a value x such that all
	// nodes less than x comes before all nodes greater than or equal to x
	public LinkedList partiton(LinkedList linkedList, int x) {
		Node currentNode = linkedList.head;
		linkedList.tail = linkedList.head;
		while (currentNode != null) {
			Node next = currentNode.next;
			if (currentNode.value < x) {
				currentNode.next = linkedList.head;
				linkedList.head = currentNode;
			} else {
				linkedList.tail.next = currentNode;
				linkedList.tail = currentNode;
			}
			currentNode = next;
		}
		linkedList.tail.next = null;
		return linkedList;
	}

	// sum lists - You have two numbers represented by a linked list, where each
	// node contains a single digit. The digits are stored in reverse order, such
	// that the 1's digit is at the head of the list. Write a function that adds the
	// two numbers and returns the sum as a linked list.
	// list1 = 7 -> 1 -> 6
	// list2 = 5 -> 9 -> 2
	// result = 2 -> 1 -> 9
	public LinkedList sumLists(LinkedList linkedList1, LinkedList linkedList2) {
		int num1 = getNumber(linkedList1);
		int num2 = getNumber(linkedList2);
		String sum = String.valueOf(num1 + num2);
		LinkedList newLinkedList = new LinkedList();
		for (int i = sum.length() - 1; i >= 0; i--) {
			newLinkedList.insertNode(Integer.valueOf(String.valueOf(sum.charAt(i))));
		}
		return newLinkedList;
	}

	private int getNumber(LinkedList linkedList) {
		Node currentNode = linkedList.head;
		int num = 0;
		int i = 1;
		while (currentNode != null) {
			num += (currentNode.value * i);
			i = i * 10;
			currentNode = currentNode.next;
		}
		return num;
	}

	// Intersection
	// Given two (singly) linked lists, determine if the two lists intersect. Return
	// the intersecting node. Note that the intersection is defined based on
	// reference, not value. That is, if the kth node of the first linked list is
	// the exact same node (by reference) as the jth node of the second linked list,
	// then they are intersecting.

	// LinkedList llA = new LinkedList();
	// llA.insertNode(3);
	// llA.insertNode(1);
	// llA.insertNode(5);
	// llA.insertNode(9);
	// LinkedList llB = new LinkedList();
	// llB.insertNode(2);
	// llB.insertNode(4);
	// llB.insertNode(6);
	// Exercise ex = new Exercise();
	// ex.addSameNode(llA, llB, 7);
	// ex.addSameNode(llA, llB, 2);
	// ex.addSameNode(llA, llB, 1);
	// Node inter = ex.findIntersection(llA, llB);
	// System.out.println(inter.value);
	// 7

	// get Kth Node
	Node getKthNode(Node head, int k) {
		Node current = head;
		while (k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}
	
	//intersection Method
	public Node findIntersection(LinkedList linkedList1, LinkedList linkedList2) {
		if(linkedList1.head == null || linkedList2.head == null)
			return null;
		if(linkedList1.tail != linkedList2.tail) {
			return null;
		}
		Node shorter = new Node();
		Node longer = new Node();
		if(linkedList1.size > linkedList2.size) {
			longer = linkedList1.head;
			shorter = linkedList2.head;
		}else {
			longer = linkedList2.head;
			shorter = linkedList1.head;
		}
		longer = getKthNode(longer, Math.abs(linkedList1.size - linkedList2.size));
		while(shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		return longer;
	}
	
	// Add same node
	void addSameNode(LinkedList linkedList1, LinkedList linkedList2, int nodeValue) {
		Node newNode = new Node();
		newNode.value = nodeValue;
		newNode.next = null;
		linkedList1.tail.next = newNode;
		linkedList1.tail = newNode;
		linkedList2.tail.next = newNode;
		linkedList2.tail = newNode;
	}

}
