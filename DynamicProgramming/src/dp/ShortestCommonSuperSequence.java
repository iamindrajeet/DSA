package dp;

import java.util.Arrays;

/*
 * s1 : abacd
 * s2 : bcde
 * 
 * SCS = s : bcde --> common substring for which both s1 and s2 are subsequence of s
 * 
 * 
 * 
 */
public class ShortestCommonSuperSequence {
	public static void main(String[] args) {
		String s1 = "abacd";
		String s2 = "bcde";
		int m = s1.length();
		int n = s2.length();
		int[][] memo = new int[m+1][n+1];
		for(int [] a : memo)
			Arrays.fill(a, -1);
		int lcs = solve(s1, s2, m, n, memo);
		System.out.println(Math.abs(m + (n - lcs)));
	}
	
	public static int solve(String s1, String s2, int m , int n, int[][] memo) {
		if(m == 0 || n == 0)
			return 0;
		if(memo[m][n] != -1)
			return memo[m][n];
		int ans = 0;
		if(s1.charAt(m - 1) == s2.charAt(n - 1))
			ans = 1 + solve(s1, s2, m - 1, n - 1, memo);
		else {
			ans = Math.max(solve(s1, s2, m - 1, n, memo), solve(s1, s2, m, n -1, memo));
		}
		memo[m][n] = ans;
		return ans;
	}
}
