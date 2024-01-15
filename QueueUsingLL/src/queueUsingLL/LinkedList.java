package queueUsingLL;

public class LinkedList {
	public Node head, tail;
	public int size = 0;

	public void createSinglyLinkedList(int nodeValue) {
		Node newNode = new Node();
		newNode.value = nodeValue;
		newNode.next = null;
		head = tail = newNode;
		size++;
	}

	public void insertInLinkedList(int nodeValue, int location) {
		Node newNode = new Node();
		newNode.value = nodeValue;
		if (head == null) {
			createSinglyLinkedList(nodeValue);
			return;
		} else if (location == 0) {
			newNode.next = head;
			head = newNode;
		} else if (location >= size) {
			tail.next = newNode;
			tail = newNode;
			newNode.next = null;
		} else {
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			newNode.next = tempNode.next;
			tempNode.next = newNode;
		}
		size++;
	}

	public void deletionSinglyLL(int location) {
		if (head == null) {
			System.out.println("SLL doesn't exist");
			return;
		} else if (location == 0) {
			head = head.next;
			if (size == 1)
				tail = null;
			size--;
		} else if (location >= size) {
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			tempNode.next = null;
			tail = tempNode;
			size--;
		} else {
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			tempNode.next = tempNode.next.next;
			size--;
		}
	}
	
	public void deleteEntireSLL() {
		head = tail = null;
		System.out.println("The SLL deleted successfully!!");
	}
}
