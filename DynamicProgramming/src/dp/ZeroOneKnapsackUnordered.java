package dp;

import java.util.Arrays;

/*
 * Unbounded Knapsack (Repetition of items allowed)
 * 
 * Given a knapsack weight W and a set of n items with certain value val and weight wt, we need 
 * to calculate the maximum amount that could make up this quantity exactly. 
 * This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
 * 
 * The only change that we need to do for unordered knapsack is that we replace the below line in class knapsack :
 * 				profit[n] + knapSack(n - 1, profit, weight, capacity - weight[n], memo));
 * 
 * to --- 		profit[n] + knapSack(n, profit, weight, capacity - weight[n], memo));
 * 
 * T.C -- O(N * capacity)
 * 
 * S.C - O(N * capacity) + O(N)
 * 
 * 
 * 
 */
public class ZeroOneKnapsackUnordered {
	public static void main(String[] args) {
		int profit[] = new int[] { 60, 100, 120 };
		int weight[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = profit.length;
		int[][] memo = new int[n + 1][W + 1];
		for (int[] a : memo) {
			Arrays.fill(a, -1);
		}
		System.out.println(knapSack(n - 1, profit, weight, W, memo));
	}

	public static int knapSack(int n, int[] profit, int[] weight, int capacity, int[][] memo) {
		// Base case
		if (n < 0 || capacity <= 0)
			return 0;

		if (memo[n][capacity] != -1)
			return memo[n][capacity];

		int ans;
		// if current wt. is greater than bag capacity skip the current item
		if (weight[n] > capacity)
			ans = knapSack(n - 1, profit, weight, capacity, memo);
		// if wt is not greater than capacity it means we can take that item
		else
			ans = Math.max(knapSack(n - 1, profit, weight, capacity, memo),
					profit[n] + knapSack(n, profit, weight, capacity - weight[n], memo));

		memo[n][capacity] = ans;

		return ans;
	}
}
