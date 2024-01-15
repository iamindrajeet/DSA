package circularLL.src.main;

public class CircularSinglyLinkedList {
	public Node head;
	public Node tail;
	public int size;

	public Node createCircularLinkedList(int nodeValue) {
		head = new Node();
		Node node = new Node();
		node.value = nodeValue;
		node.next = node;
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	public void insertIntoCircularSinglyLinkedList(int nodeValue, int location) {
		Node node = new Node();
		node.value = nodeValue;
		if (head == null) {
			createCircularLinkedList(nodeValue);
			return;
		}
		// insert at beginning
		else if (location == 0) {
			node.next = head;
			head = node;
			tail.next = head;
		}
		// insert at end
		else if (location >= size) {
			tail.next = node;
			tail = node;
			tail.next = head;
		}

		// insert at specified location
		else {
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			node.next = tempNode.next;
			tempNode.next = node;
		}
		size++;
	}

	// CSLL traversal
	public void traverseCSLL() {
		if (head == null) {
			System.out.println("CSLL doesn't exist");
			return;
		} else {
			Node tempNode = head;
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.value);
				if (i != size - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.next;
			}
		}
	}

	// searching in CSLL
	public boolean searchCSLL(int nodeValue) {
		if (head != null) {
			Node tempNode = head;
			for (int i = 0; i < size; i++) {
				if (tempNode.value == nodeValue) {
					System.out.println("found at location: " + i);
					return true;
				}
				tempNode = tempNode.next;
			}
		}
		System.out.println("Node not found");
		return false;
	}

	// delete from CSLL
	public void deleteFromCSLL(int location) {
		if (head == null) {
			System.out.println("The CSLL doesn't exist");
		}
		// delete from beginning
		else if (location == 0) {
			// case when we have more than one node
			head = head.next;
			tail.next = head;
			size--;
			// case when we have only one node
			if (size == 0) {
				tail = null;
				head.next = null;
				head = null;
			}
		}
		// delete from end of CSLL
		else if (location >= size) {
			Node tempNode = head;
			for (int i = 0; i < size - 1; i++) {
				tempNode = tempNode.next;
			}
			if (tempNode == head) {
				head.next = null;
				tail = head = null;
				size--;
				return;
			}
			tempNode.next = head;
			tail = tempNode;
			size--;
		}
		// delete from any specified location
		else {
			Node tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.next;
			}
			tempNode.next = tempNode.next.next;
			size--;
		}
	}

	// delete entire CSLL
	public void deleteEntireCSLL() {
		if (head == null) {
			System.out.println("The CSLL doesn't exist");
		} else {
			head = null;
			tail.next = null;
			tail = null;
			System.out.println("The CSLL has been deleted!!");
		}
	}
}
