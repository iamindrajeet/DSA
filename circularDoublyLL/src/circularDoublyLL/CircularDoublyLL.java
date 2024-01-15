package circularDoublyLL;

public class CircularDoublyLL {
	public Node head, tail;
	public int size = 0;

	// create a circular doubly LL
	public Node createCDLL(int nodeValue) {
		head = new Node();
		Node newNode = new Node();
		newNode.value = nodeValue;
		head = tail = newNode;
		newNode.next = newNode;
		newNode.prev = newNode;
		size = 1;
		return head;
	}

	// insert in CDLL
	public void insertInCDLL(int nodeValue, int location) {
		Node newNode = new Node();
		newNode.value = nodeValue;
		if (head == null) {
			createCDLL(nodeValue);
			return;
		}
		// insert at beginning
		else if (location == 0) {
			newNode.next = head;
			newNode.prev = tail;
			head.prev = newNode;
			tail.next = newNode;
			head = newNode;
		}
		// insert at end
		else if (location >= size) {
			newNode.next = head;
			newNode.prev = tail;
			head.prev = newNode;
			tail.next = newNode;
			tail = newNode;
		}
		// insert at specified location
		else {
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			newNode.next = tempNode.next;
			newNode.prev = tempNode;
			tempNode.next.prev = newNode;
			tempNode.next = newNode;
		}
		size++;
	}

	// traverse CDLL in forward direction
	public void traverseCDLLForward() {
		if (head == null) {
			System.out.println("CDLL is empty!!!");
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
		System.out.println();
	}

	// traverse CDLL in reverse direction
	public void traverseCDLLReverse() {
		if (head == null) {
			System.out.println("CDLL is empty!!!");
			return;
		} else {
			Node tempNode = tail;
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.value);
				if (i != size - 1) {
					System.out.print(" <- ");
				}
				tempNode = tempNode.prev;
			}
		}
		System.out.println();
	}

	// searching in CDLL
	public boolean searchInCDLL(int nodeValue) {
		if (head != null) {
			Node tempNode = head;
			for (int i = 0; i < size; i++) {
				if (tempNode.value == nodeValue) {
					System.out.println("The node is found at location : " + i);
					return true;
				}
				tempNode = tempNode.next;
			}
		}
		System.out.println("Node not found!!!");
		return false;
	}

	// delete in CDLL
	public void deleteFromCDLL(int location) {
		if (head == null) {
			System.out.println("CDLL doesn't exist!!!");
			return;
		}
		// delete from beginningg
		else if (location == 0) {
			// case when there's only one node in CDLL
			if (size == 1) {
				head.next = head.prev = null;
				head = tail = null;
				size--;
				return;
			}
			// case when we have more than 1 node in CDLL
			else {
				head = head.next;
				head.prev = tail;
				tail.next = head;
				size--;
			}
		}
		// delete from end
		else if (location >= size) {
			// case when there's only one node
			if (size == 1) {
				head.next = head.prev = null;
				head = tail = null;
				size--;
				return;
			}
			// case when there's more than one node
			else {
				tail = tail.prev;
				tail.next = head;
				head.prev = tail;
				size--;
			}
		}
		// delete from any specified location
		else {
			Node tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.next;
			}
			tempNode.next = tempNode.next.next;
			tempNode.prev = tempNode;
			size--;
		}
	}
	//delete entire CDLL
	public void deleteCDLL() {
		Node tempNode = head;
		for(int i=0;i<size; i++) {
			tempNode.prev = null;
			tempNode = tempNode.next;
		}
		tail.next = null;
		head = tail = null;
		System.out.println("CDLL has been deleted!!");
	}

}
