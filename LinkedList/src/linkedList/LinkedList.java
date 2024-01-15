package linkedList;

public class LinkedList {
	public Node head;
	public Node tail;
	public int size = 0;

	// create linked list
	public void createLL(int nodeValue) {
		Node newNode = new Node();
		newNode.value = nodeValue;
		newNode.next = null;
		head = tail = newNode;
		size++;
	}

	// insert a node at the end of LL
	public void insertNode(int nodeValue) {
		if(head == null && tail == null) {
			createLL(nodeValue);
			return;
		}
		Node newNode = new Node();
		newNode.value = nodeValue;
		newNode.next = null;
		tail.next = newNode;
		tail = newNode;
		size++;
	}

	// traverse LL
	public void traverseLL() {
		Node tempNode = head;
		for (int i = 0; i < size; i++) {
			System.out.print(tempNode.value);
			if (i != size - 1) {
				System.out.print(" -> ");
			}
			tempNode = tempNode.next;
		}
		System.out.println("\n");
	}

}
