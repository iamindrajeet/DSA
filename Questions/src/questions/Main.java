package questions;

public class Main {
	public static void main(String[] args) {
		QueueViaStack queueViaStack = new QueueViaStack();
		queueViaStack.enQueue(1);
		queueViaStack.enQueue(2);
		queueViaStack.enQueue(3);
		System.out.println(queueViaStack.peek());
//		System.out.println(queueViaStack.deQueue());
//		System.out.println(queueViaStack.deQueue());
		queueViaStack.enQueue(4);
		System.out.println(queueViaStack.peek());
	}
}
