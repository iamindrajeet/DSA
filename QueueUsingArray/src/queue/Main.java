package queue;

public class Main {
	public static void main(String[] args) {
//		QueueArray newQueue = new QueueArray(3);
//		boolean isFull = newQueue.isFull();
//		System.out.println(isFull);
//		boolean isEmpty = newQueue.isEmpty();
//		System.out.println(isEmpty);
//		newQueue.enQueue(1);
//		newQueue.enQueue(4);
//		newQueue.enQueue(10);
//		newQueue.enQueue(11);
//		System.out.println(newQueue.peek());
//		System.out.println(newQueue.deQueue());
//		System.out.println(newQueue.deQueue());
//		//System.out.println(newQueue.deQueue());
//		//System.out.println(newQueue.deQueue());
//		newQueue.enQueue(12);
//		System.out.println(newQueue.peek());
//		newQueue.deleteQueue();
		
		//circular queue
		CircularQueueArray newCQ = new CircularQueueArray(3);
		boolean result = newCQ.isEmpty();
		System.out.println(result);
		newCQ.enQueue(10);
		newCQ.enQueue(20);
		newCQ.enQueue(30);
		//newCQ.enQueue(40);
		System.out.println(newCQ.deQueue());
		System.out.println(newCQ.deQueue());
		//System.out.println(newCQ.deQueue());
		newCQ.enQueue(40);
		newCQ.enQueue(50);
		newCQ.enQueue(60);
		
		System.out.println(newCQ.peek());
		newCQ.traverse();
	}

}
