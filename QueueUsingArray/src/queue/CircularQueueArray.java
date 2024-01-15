package queue;

public class CircularQueueArray {
	int[] arr;
	int topOfQueue, beginningOfQueue;

	public CircularQueueArray(int size) {
		this.arr = new int[size];
		this.topOfQueue = this.beginningOfQueue = -1;
		System.out.println("The circular queue is successfully created with size of : " + size);
	}

	// isFull
	public boolean isFull() {
		if ((topOfQueue == arr.length - 1 && beginningOfQueue == 0) || topOfQueue + 1 == beginningOfQueue) {
			return true;
		}
		return false;
	}

	// isEmpty
	public boolean isEmpty() {
		if (beginningOfQueue == -1)
			return true;
		return false;
	}

	// enqueue
	public void enQueue(int value) {
		// check if queue is full
		if (isFull()) {
			System.out.println("Circular Queue is full!!!");
		}
		// checking if queue is empty or not. If it's empty beginningOfQueue should be 0
		else if (isEmpty()) {
			beginningOfQueue = 0;
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("Sucessfully inserted " + value + " in the circular queue!!");
		} else {
			if (topOfQueue + 1 == arr.length) {
				topOfQueue = 0;
			} else {
				topOfQueue++;
			}
			arr[topOfQueue] = value;
			System.out.println("Sucessfully inserted " + value + " in the circular queue!!");
		}
	}

	// dequeue
	public int deQueue() {
		int deQueuedElement = -1;
		if (isEmpty()) {
			System.out.println("Circular Queue is empty!!!");
		} else {
			deQueuedElement = arr[beginningOfQueue];
			arr[beginningOfQueue] = Integer.MIN_VALUE;
			if (beginningOfQueue == topOfQueue)
				topOfQueue = beginningOfQueue = -1;
			else if (beginningOfQueue + 1 == arr.length) {
				beginningOfQueue = 0;
			} else {
				beginningOfQueue++;
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

	public void traverse() {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
