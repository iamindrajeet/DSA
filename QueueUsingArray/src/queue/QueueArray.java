package queue;

public class QueueArray {
	int[] arr;
	int topOfQueue, beginningOfQueue;

	public QueueArray(int size) {
		this.arr = new int[size];
		this.topOfQueue = this.beginningOfQueue = -1;
		System.out.println("The queue is successfully created with size of : " + size);
	}

	// isFull
	public boolean isFull() {
		if (topOfQueue == arr.length - 1) {
			return true;
		}
		return false;
	}

	// isEmpty
	public boolean isEmpty() {
		if (beginningOfQueue == -1 || beginningOfQueue == arr.length)
			return true;
		return false;
	}

	// enqueue
	public void enQueue(int value) {
		// check if queue is full
		if (isFull()) {
			System.out.println("Queue is full!!!");
		}
		// checking if queue is empty or not. If it's empty beginningOfQueue should be 0
		else if (isEmpty()) {
			beginningOfQueue = 0;
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("Sucessfully inserted " + value + " in the queue!!");
		} else {
			arr[++topOfQueue] = value;
			System.out.println("Sucessfully inserted " + value + " in the queue!!");
		}
	}

	// dequeue
	public int deQueue() {
		int deQueuedElement = -1;
		if (isEmpty()) {
			System.out.println("Queue is empty!!!");
		} else {
			deQueuedElement = arr[beginningOfQueue];
			beginningOfQueue++;
			if (beginningOfQueue > topOfQueue) {
				topOfQueue = beginningOfQueue = -1;
			}
		}
		return deQueuedElement;
	}

	// peek
	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty!!!");
			return -1;
		} else {
			return arr[beginningOfQueue];
		}
	}

	// delete Queue
	public void deleteQueue() {
		arr = null;
		System.out.println("Queue is successfully deleted!!");
	}

}
