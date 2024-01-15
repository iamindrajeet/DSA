package stackUsingArray;

import java.util.Stack;

public class BalancedParanthesis {
	public boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			Character c = expression.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' || c == ']' || c == '}') {
				if (stack.isEmpty())
					return false;
				Character pop = stack.pop();
				if ((pop == '(' && c != ')') || (pop == '[' && c != ']') || (pop == '{' && c != '}')) {
					return false;
				}
			}
		}
		return true;
	}

}
