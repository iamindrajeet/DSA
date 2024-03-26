package miscellaneous;

import java.util.Stack;

public class NextSmallerRight_NSR {
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 0 , 0, 1, 4};
		int[] nextSmallerRight = nextSmallerRight(arr);
		for(int i : nextSmallerRight) {
			System.out.print(i + " ");
		}
	}
	
	/*
	 * For next smaller or greater in right side traverse right to left. If stack is
	 * empty then answer is -1. If top of stack is less than current element then ans
	 * is the element at top of stack. If top of stack is greater than or equal to the current
	 * element then pop the element at top of stack, keep doing it unless we get an
	 * element less than the current element or the stack is empty. If the stack
	 * is empty then answer is -1 otherwise we know that the element at the top of
	 * stack is less than the current element which will be the answer. Push the
	 * current element in the stack in every step no matter what.
	 */
	public static int[] nextSmallerRight(int[] arr) {
		int[] result = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		int j = arr.length - 1;
		for(int i = arr.length - 1; i >= 0; i--) {
			if(stack.isEmpty()) {
				result[j--] = -1;
			}
			else if(!stack.isEmpty() && stack.peek() < arr[i]) {
				result[j--] = stack.peek();
			}
			else if(!stack.isEmpty() && stack.peek() >= arr[i]) {
				while(!stack.isEmpty() && stack.peek() >= arr[i]) {
					stack.pop();
				}
				if(stack.isEmpty())
					result[j--] = -1;
				else
					result[j--] = stack.peek();
			}
			stack.push(arr[i]);
		}
		return result;
	}
}
