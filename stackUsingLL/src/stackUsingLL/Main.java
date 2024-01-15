package stackUsingLL;

public class Main {
	public static void main(String[] args) {
		Stack newStack = new Stack();
		boolean result = newStack.isEmpty();
		System.out.println(result);
		newStack.push(1);
		newStack.push(2);
		newStack.push(3);
		newStack.push(4);
		result = newStack.isEmpty();
		System.out.println(result);
		int poppedElement1 = newStack.pop();
		System.out.println(poppedElement1);
		int poppedElement2 = newStack.pop();
		System.out.println(poppedElement2);
		int peekedElement1 = newStack.pop();
		System.out.println(peekedElement1);
		newStack.deleteStack();
		result = newStack.isEmpty();
		System.out.println(result);
	}

}
