package miscellaneous;

import java.util.Stack;

public class MaximumStockSpanProblem {
	public static void main(String[] args) {
		int[] stocks = new int[] { 20, 30, 10, 20, 15, 40, 20 };
		int[][] result = calculateDaysToBeatTheMaximum(stocks);

		// Printing NGR and NGRi arrays
		for (int i = 0; i < stocks.length; i++) {
			System.out.println("NGR[" + i + "]: " + result[0][i] + ", NGRi[" + i + "]: " + result[1][i]);
		}
		
		int[] spanArray = new int[stocks.length];
		for(int i = 0; i < stocks.length; i++) {
			spanArray[i] = Math.abs(i - result[1][i]);
		}
		
		System.out.println();
		
		for (int i = 0; i < spanArray.length; i++) {
			System.out.print(spanArray[i] + " ");
		}
	}

	public static int[][] calculateDaysToBeatTheMaximum(int[] stocks) {
		int n = stocks.length;
		int[][] result = new int[2][n];
		Stack<Integer> stack = new Stack<>();

		for (int i = n - 1; i >= 0; i--) {

			if (stack.isEmpty()) {
				result[0][i] = -1;
				result[1][i] = n;
			}

			else if (!stack.isEmpty() && stocks[stack.peek()] > stocks[i]) {
				result[0][i] = stocks[stack.peek()];
				result[1][i] = stack.peek();
			}

			else if (!stack.isEmpty() && stocks[stack.peek()] <= stocks[i]) {
				while (!stack.isEmpty() && stocks[stack.peek()] <= stocks[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					result[0][i] = -1;
					result[1][i] = n;
				} else {
					result[0][i] = stocks[stack.peek()];
					result[1][i] = stack.peek();
				}
			}
			// Push current element's index to stack
			stack.push(i);
		}
		return result;
	}
}
