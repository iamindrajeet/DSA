package queueUsingLL;

public class Main {
	public static void main(String[] args) {
		QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();
		boolean isEmpty = queueUsingLinkedList.isEmpty();
		System.out.println(isEmpty);
		queueUsingLinkedList.enQueue(10);
		queueUsingLinkedList.enQueue(20);
		queueUsingLinkedList.enQueue(30);
		isEmpty = queueUsingLinkedList.isEmpty();
		System.out.println(isEmpty);
		int deQueuedElement = queueUsingLinkedList.deQueue();
		System.out.println(deQueuedElement);
		deQueuedElement = queueUsingLinkedList.deQueue();
		System.out.println(deQueuedElement);
		int peekedElement = queueUsingLinkedList.peek();
		System.out.println(peekedElement);
		queueUsingLinkedList.deleteQueue();
		isEmpty = queueUsingLinkedList.isEmpty();
		System.out.println(isEmpty);
	}

}
