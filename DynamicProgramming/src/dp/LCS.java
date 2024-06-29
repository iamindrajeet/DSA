package dp;

import java.util.Arrays;

public class LCS {
	public static void main(String[] args) {
		String s1 = "abbacdeaf";
		String s2 = "babedae";

		int m = s1.length();
		int n = s2.length();
		int[][] memo = new int[m + 1][n + 1];

		for (int[] a : memo)
			Arrays.fill(a, -1);

		System.out.println(lcs(s1, s2, m, n, memo)); // Pass m and n instead of m - 1 and n - 1

		// Traverse memoization table to get LCS
		String lcs = getLCS(s1, s2, m, n, memo);

		for (int[] a : memo) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
		System.out.println("LCS: " + lcs);
	}

	public static int lcs(String s1, String s2, int m, int n, int[][] memo) {
		if (m == 0 || n == 0)
			return 0;

		if (memo[m][n] != -1)
			return memo[m][n];

		int ans = 0;

		if (s1.charAt(m - 1) == s2.charAt(n - 1)) // Access characters at index m - 1 and n - 1
			ans = 1 + lcs(s1, s2, m - 1, n - 1, memo);
		else {
			ans = Math.max(lcs(s1, s2, m, n - 1, memo), lcs(s1, s2, m - 1, n, memo));
		}
		memo[m][n] = ans;
		return ans;
	}

	// Traverse memoization table to get LCS
	public static String getLCS(String s1, String s2, int m, int n, int[][] memo) {
	    StringBuilder lcs = new StringBuilder();

	    while (m > 0 && n > 0) {
	        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
	            lcs.append(s1.charAt(m - 1)); // Add character to the beginning of LCS string
	            m--;
	            n--;
	        } else if (memo[m - 1][n] > memo[m][n - 1]) {
	            m--;
	        } else {
	            n--;
	        }
	    }

	    return lcs.reverse().toString();
	}


	// Traverse memoization table to get SCS
	public static String getSCS(String s1, String s2, int m, int n, int[][] memo) {
		StringBuilder scs = new StringBuilder();

		while (m > 0 && n > 0) {
			if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
				scs.insert(0, s1.charAt(m - 1)); // Add common character to the beginning of SCS string
				m--;
				n--;
			} else {
				// Choose the character which leads to the maximum length of SCS
				if (memo[m - 1][n] > memo[m][n - 1]) {
					scs.insert(0, s1.charAt(m - 1)); // Add character from s1 to SCS
					m--;
				} else {
					scs.insert(0, s2.charAt(n - 1)); // Add character from s2 to SCS
					n--;
				}
			}
		}

		// Append remaining characters of s1 and s2 to SCS
		while (m > 0) {
			scs.insert(0, s1.charAt(m - 1));
			m--;
		}
		while (n > 0) {
			scs.insert(0, s2.charAt(n - 1));
			n--;
		}

		return scs.toString();
	}
}
