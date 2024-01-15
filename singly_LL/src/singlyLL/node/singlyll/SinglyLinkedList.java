package singlyLL.node.singlyll;

import singlyLL.node.Node;

public class SinglyLinkedList {
	public Node head;
	public Node tail;
	public int size;

	// create a node
	public Node createSinglyLinkedList(int nodeValue) {
		head = new Node();
		Node node = new Node();
		node.next = null;
		node.value = nodeValue;
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	// insert method single LL
	public void insertInLinkedList(int nodeValue, int location) {
		Node node = new Node();
		node.value = nodeValue;
		if (head == null) {
			createSinglyLinkedList(nodeValue);
			return;
		}
		// insert in beginning
		else if (location == 0) {
			node.next = head;
			head = node;
		}
		// insert at end
		else if (location >= size) {
			node.next = null;
			tail.next = node;
			tail = node;
		}
		// insert in between
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

	// singly LL traversal
	public void traverseSinglyLL() {
		if (head == null) {
			System.out.println("SLL doesn't exist");
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

	// search SLL
	public int searchSinglyLL(int nodeValue) {
		if (head == null) {
			System.out.println("SLL doesn't exist");
		} else {
			Node tempNode = head;
			for (int i = 0; i < size; i++) {
				if (tempNode.value == nodeValue) {
					return i + 1;
				} else {
					tempNode = tempNode.next;
				}
			}
		}
		return 0;
	}

	// deletion SLL
	public void deletionSinglyLL(int location) {
		if (head == null) {
			System.out.println("SLL doesn't exist");
			return;
		}
		// delete from beginning
		else if(location == 0) {
			head = head.next;
			size--;
			if(size == 0)
			tail = null;
		} 
		// delete from end
		else if(location >= size) {
			Node tempNode =  head;
			for(int i=0; i<size-1; i++) {
				tempNode = tempNode.next;
			}
			if(tempNode == head) {
				head = tail = null;
				size--;
				return;
			}
			tempNode.next = null;
			tail = tempNode;
			size--;
		}
		// delete from between
		else {
			Node tempNode =  head;
			for(int i=0; i<location - 1; i++) {
				tempNode = tempNode.next;
			}
			tempNode.next = tempNode.next.next;
			size--;
			return;
		}
	}
	
	//delete entire SLL
	public void deleteEntireSLL() {
		head = tail = null;
		System.out.println("The SLL deleted successfully!!");
	}
}
