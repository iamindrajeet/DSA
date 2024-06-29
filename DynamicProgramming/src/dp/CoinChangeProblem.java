package dp;

import java.util.Arrays;

public class CoinChangeProblem {
	public static void main(String[] args) {
		int[] coins = { 2, 5, 10, 1 };
		int amount = 27;
		int n = coins.length;
		int[][] dp = new int[n][amount + 1];
		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}

		int result = computeMinCoins(n - 1, coins, amount, dp);
		result = result == (int) (1e9) ? -1 : result;
		System.out.println(result);
	}

	public static int computeMinCoins(int index, int[] coins, int amount, int[][] dp) {
		if (amount == 0) {
			return 0;
		}

		if (index < 0 || amount < 0) {
			return (int) (1e9);
		}

		if (dp[index][amount] != -1) {
			return dp[index][amount];
		}

		int ans = 0;
		ans = computeMinCoins(index - 1, coins, amount, dp);

		// int take = (int)(1e9);
		if (amount >= coins[index]) {
			ans = Math.min(computeMinCoins(index - 1, coins, amount, dp),
					1 + computeMinCoins(index, coins, amount - coins[index], dp));
		}

		dp[index][amount] = ans;

		return ans;
	}
}
