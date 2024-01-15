package doublyLL.doublyLinkedList;

import doublyLL.node.DoublyNode;

public class DoublyLL {
	public DoublyNode head, tail;
	public int size = 0;

	public DoublyNode createDoublyLL(int nodeValue) {
		head = new DoublyNode();
		DoublyNode newNode = new DoublyNode();
		newNode.value = nodeValue;
		newNode.next = null;
		newNode.prev = null;
		head = newNode;
		tail = newNode;
		size = 1;
		return head;
	}

	// insertion in DLL
	public void insertInDLL(int nodeValue, int location) {
		DoublyNode newNode = new DoublyNode();
		newNode.value = nodeValue;
		if (head == null) {
			createDoublyLL(nodeValue);
			return;
		}
		// insert in beginning
		else if (location == 0) {
			newNode.prev = null;
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		// insert at end
		else if (location >= size) {
			newNode.next = null;
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		// insert at specified location
		else {
			DoublyNode tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			tempNode.next.prev = newNode;
			newNode.next = tempNode.next;
			tempNode.next = newNode;
			newNode.prev = tempNode;
		}
		size++;
	}

	// forward traverse DLL
	public void traverseDLL() {
		if (head != null) {
			DoublyNode tempNode = head;
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.value);
				if (i != size - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.next;
			}
		} else {
			System.out.println("DLL doesn't exist");
		}
		System.out.println();
	}

	// reverse traverse DLL
	public void reverseTraverseDLL() {
		if (head != null) {
			DoublyNode tempNode = tail;
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.value);
				if (i != size - 1) {
					System.out.print(" <- ");
				}
				tempNode = tempNode.prev;
			}
		} else {
			System.out.println("DLL doesn't exist");
		}
		System.out.println();
	}
	//search in DLL
	public boolean searchInDLL(int nodeValue) {
		if(head != null) {
			DoublyNode tempNode = head;
			for(int i=0; i<size; i++) {
				if(tempNode.value == nodeValue) {
					System.out.println("Node found at location: " + i);
					return true;
				}
				tempNode = tempNode.next;
			}
		}
		System.out.println("Node not found!!");
		return false;
	}
	//deletion in DLL
	public void  deleteInDLL(int location) {
		if(head == null) {
			System.out.println("DLL doesnn't exist!!");
			return;
		}else {
			//delete node at beginning
			if(location == 0) {
				// delete node at beginning if there's only 1 node
				if(size == 1) {
					head = null;
					tail = null;
					size--;
					return;
				}
				// delete node at beginning where there's more than 1 node
				else {
					head = head.next;
					head.prev = null;
					size--;
					return;
				}
			}
			// delete node at the end
			else if(location >= size) {
				DoublyNode tempNode = tail.prev;
				// delete node at end if there's only 1 node
				if(size == 1) {
					head = null;
					tail = null;
					size--;
					return;
				}
				// delete node at end if there's more than 1 node
				else {
					tempNode.next = null;
					tail = tempNode;
					size--;
					return;
				}
			}
			// delete a node at any specified location
			else {
				DoublyNode tempNode = head;
				for(int i=0; i < location-1; i++) {
					tempNode = tempNode.next;
				}
				tempNode.next = tempNode.next.next;
				tempNode.next.prev = tempNode;
				size--;
			}
		}
	}
	//deletion entire DLL
	public void deleteEntireDLL() {
		DoublyNode tempNode = head;
		for(int i=0; i<size; i++) {
			tempNode.prev = null;
			tempNode = tempNode.next;
		}
		head = tail = null;
		System.out.println("The DLL has been deleted!!!");
	}
}
