package dp;

import java.util.Arrays;

/*
 * T.C - without DP is O(2^N) because every time we are taking two decision either to pick it or not which results in
 * two branch at every level.
 * 
 * T.C - If we use DP i.e memoization then the T.C boils down to O(n*capacity) because we will go through the whole array of size N and we will also check if that
 * item can be included in the bag or not.
 * 
 * 
 * S.C - O(N * capacity) + O(N) -- the use of a 2D array data structure for storing intermediate states 
 * and O(N) auxiliary stack space(ASS) has been used for recursion stack
 * 
 */
public class ZeroOneKnapsackProblem {
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

		if (memo[n][capacity] != 0)
			return memo[n][capacity];

		int ans;
		// if current wt. is greater than bag capacity skip the current item
		if (weight[n] > capacity)
			ans = knapSack(n - 1, profit, weight, capacity, memo);
		// if wt is not greater than capacity it means we can take that item
		else
			ans = Math.max(knapSack(n - 1, profit, weight, capacity, memo),
					profit[n] + knapSack(n - 1, profit, weight, capacity - weight[n], memo));

		memo[n][capacity] = ans;

		return ans;
	}
}
