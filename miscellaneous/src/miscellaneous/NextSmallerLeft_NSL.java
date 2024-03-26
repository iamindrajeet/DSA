package miscellaneous;

import java.util.Stack;

public class NextSmallerLeft_NSL {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 0, 0, 1, 4 };
		int[] nextSmallerLeft = nextSmallerLeft(arr);
		for (int i : nextSmallerLeft) {
			System.out.print(i + " ");
		}
	}

	/*
	 * For next smaller or greater in left side traverse left to right. If stack is
	 * empty then answer is -1. If top of stack is less than current element then ans
	 * is the element at top of stack. If top of stack is greater than or equal to the current
	 * element then pop the element at top of stack, keep doing it unless we get an
	 * element less than the current element or the stack is empty. If the stack
	 * is empty then answer is -1 otherwise we know that the element at the top of
	 * stack is less than the current element which will be the answer. Push the
	 * current element in the stack in every step no matter what.
	 */
	public static int[] nextSmallerLeft(int[] arr) {
		int[] result = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < arr.length; i++) {
			if(stack.isEmpty()) {
				result[i] = -1;
			}
			else if(!stack.isEmpty() && stack.peek() < arr[i]) {
				result[i] = stack.peek();
			}
			else if(!stack.isEmpty() && stack.peek() >= arr[i]) {
				while(!stack.isEmpty() && stack.peek() >= arr[i]) {
					stack.pop();
				}
				if(stack.isEmpty())
					result[i] = -1;
				else
					result[i] = stack.peek();
			}
			stack.push(arr[i]);
		}
		return result;
	}
}
