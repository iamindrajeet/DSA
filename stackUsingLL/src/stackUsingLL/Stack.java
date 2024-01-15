package stackUsingLL;

public class Stack {
	LinkedList linkedList;

	public Stack() {
		linkedList = new LinkedList();
	}

	// push method
	public void push(int value) {
		linkedList.insertInLinkedList(value, 0);
		System.out.println("Inserted " + value + " in stack !!");
	}

	// isEmpty
	public boolean isEmpty() {
		if (linkedList.head == null) {
			return true;
		} else
			return false;
	}

	// pop method
	public int pop() {
		int result = -1;
		if (isEmpty()) {
			System.out.println("Stack is empty!!!");
		} else {
			result = linkedList.head.value;
			linkedList.deletionSinglyLL(0);
		}
		return result;
	}

	// peek method
	public int peek() {
		int result = -1;
		if (isEmpty()) {
			System.out.println("Stack is empty!!!");
			return result;
		} else {
			result = linkedList.head.value;
			return result;
		}
	}

	// delete stack
	public void deleteStack() {
		linkedList.head = linkedList.tail = null;
		System.out.println("Stack is deleted!!!");
	}
}
