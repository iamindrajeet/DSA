package stackUsingArray;


public class Main {

	public static void main(String[] args) {
		Stack stack = new Stack(4);
		boolean isEmpty = stack.isEmpty();
		System.out.println(isEmpty);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.traverseArray();
		int poppedElement1 = stack.pop();
		System.out.println(poppedElement1);
		int poppedElement2 = stack.pop();
		System.out.println(poppedElement2);
		int peekedElement1 = stack.peek();
		System.out.println(peekedElement1);
		int peekedElement2 = stack.peek();
		System.out.println(peekedElement2);
		stack.push(5);
		stack.push(6);
		stack.traverseArray();
		BalancedParanthesis balancedParanthesis = new BalancedParanthesis();
		boolean isBalanced = balancedParanthesis.isBalanced("{(a+b)*[a*c]}");
		System.out.println(isBalanced);
		isBalanced = balancedParanthesis.isBalanced("a+b)*[a*c]}");
		System.out.println(isBalanced);
	}

}
