package stackUsingArray;

public class Stack {
	int[] arr;
	int topOfStack;

	// initialize a stack with specified size
	public Stack(int size) {
		this.arr = new int[size];
		this.topOfStack = -1;
		System.out.println("Stack is created with size of : " + size);
	}

	// Check if stack is empty
	public boolean isEmpty() {
		if (topOfStack == -1) {
			return true;
		}
		return false;
	}

	// check if stack is full
	public boolean isFull() {
		if (topOfStack == arr.length - 1) {
			return true;
		}
		return false;
	}

	// pushing elements in stack
	public void push(int value) {
		if (!isFull()) {
			arr[++topOfStack] = value;
			System.out.println("The value is successfully inserted!!!");
		} else {
			System.out.println("The stack is full!!!");
		}
	}

	// popping elements out of the stack
	public int pop() {
		if (!isEmpty()) {
			int topStack = arr[topOfStack];
			topOfStack--;
			return topStack;
		} else {
			System.out.println("Stack is empty!!!");
			return -1;
		}
	}

	// peek elements out of the stack i.e return the topmost element in stack
	public int peek() {
		if (!isEmpty()) {
			return arr[topOfStack];
		} else {
			System.out.println("Stack is empty!!!");
			return -1;
		}
	}

	public void traverseArray() {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
