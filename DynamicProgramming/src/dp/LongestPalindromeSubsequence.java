package dp;

import java.util.Arrays;

public class LongestPalindromeSubsequence {
	public static void main(String[] args) {
		String s1 = "agbcba";
		String s2 = new StringBuilder(s1).reverse().toString(); // reverse the string
		int m = s1.length();
		int n = s2.length();
		int[][] memo = new int[m + 1][n + 1];
		for (int[] a : memo)
			Arrays.fill(a, -1);
		int lcs = solve(s1, s2, m, n, memo);
		System.out.println(lcs);
		
		System.out.println(printLCS(s1, s2, m, n, memo));
	}

	public static int solve(String s1, String s2, int m, int n, int[][] memo) {
		if (m == 0 || n == 0)
			return 0;
		if (memo[m][n] != -1)
			return memo[m][n];
		int ans = 0;
		if (s1.charAt(m - 1) == s2.charAt(n - 1))
			ans = 1 + solve(s1, s2, m - 1, n - 1, memo);
		else {
			ans = Math.max(solve(s1, s2, m - 1, n, memo), solve(s1, s2, m, n - 1, memo));
		}
		memo[m][n] = ans;
		return ans;
	}

	public static String printLCS(String s1, String s2, int m, int n, int[][] memo) {
		StringBuilder sb = new StringBuilder();
		while(m > 0 && n > 0) {
			if(s1.charAt(m - 1) == s2.charAt(n - 1)) {
				sb.append(s1.charAt(m - 1));
				m--;
				n--;
			}else if(memo[m - 1][n] > memo[m][n - 1]) // if characters don't match we try to move the the max side of memo table
				m--;
			else
				n--;
		}
		return sb.reverse().toString();
	}
}
