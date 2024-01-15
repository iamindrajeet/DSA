package queueUsingLL;

public class QueueUsingLinkedList {
	LinkedList linkedList;

	public QueueUsingLinkedList() {
		this.linkedList = new LinkedList();
		System.out.println("The Queue is successfully created!!!");
	}

	// isEmpty
	public boolean isEmpty() {
		if (linkedList.head == null)
			return true;
		return false;
	}

	// enQueue
	public void enQueue(int nodeValue) {
		linkedList.insertInLinkedList(nodeValue, linkedList.size);
		System.out.println("Successfully inserted " + nodeValue + " in Queue!!!");
	}

	// dequeue
	public int deQueue() {
		int value = -1;
		if (isEmpty()) {
			System.out.println("Queue is empty!!");
		} else {
			value = linkedList.head.value;
			linkedList.deletionSinglyLL(0);
		}
		return value;
	}

	// peek
	public int peek() {
		int value = -1;
		if (isEmpty()) {
			System.out.println("Queue is empty!!");
		} else {
			value = linkedList.head.value;
		}
		return value;
	}

	// delete Queue
	public void deleteQueue() {
		linkedList.head = linkedList.tail = null;
		System.out.println("Queue is successfully deleted");
	}

}
