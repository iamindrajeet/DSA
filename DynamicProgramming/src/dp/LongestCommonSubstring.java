package dp;

import java.util.Arrays;

public class LongestCommonSubstring {
	public static void main(String[] args) {
		String s1 = "abacddeft";
		String s2 = "abacdddacdac";

		int m = s1.length();
		int n = s2.length();
		int[][] memo = new int[m + 1][n + 1];

		for (int[] row : memo) {
			Arrays.fill(row, 0); // Initialize memoization table with -1
		}

		int maxLength = LCS(s1, s2, m, n, 0); // Compute LCS length

		System.out.println("Longest Common Substring Length: " + maxLength);

		int len = LCSubStr(s1.toCharArray(), s2.toCharArray(), m, n, memo);

		System.out.println("Longest Common Substring Length: " + len);

		for (int[] a : memo) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}

		System.out.println(extractLongestCommonSubstring(s1, s2, memo));
	}

	/*
	 * 
	 * 
	 * 
	 * using recursion without memoization
	 */
	// function which returns the length of longest common substring
	static int LCS(String s1, String s2, int m, int n, int length) {
		if (m == 0 || n == 0) {
			return length;
		}

		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			length = LCS(s1, s2, m - 1, n - 1, length + 1);
		}else
			length = Math.max(length, Math.max(LCS(s1, s2, m, n - 1, 0), LCS(s1, s2, m - 1, n, 0)));
		return length;
	}

	/*
	 * using bottom approach here to fill the dp table
	 * 
	 */
	static int LCSubStr(char X[], char Y[], int m, int n, int[][] LCStuff) {
		// Create a table to store
		// lengths of longest common
		// suffixes of substrings.
		// Note that LCSuff[i][j]
		// contains length of longest
		// common suffix of
		// X[0..i-1] and Y[0..j-1].
		// The first row and first
		// column entries have no
		// logical meaning, they are
		// used only for simplicity of program

		// To store length of the longest
		// common substring
		int result = 0;

		// Following steps build
		// LCSuff[m+1][n+1] in bottom up fashion
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					LCStuff[i][j] = 0;
				else if (X[i - 1] == Y[j - 1]) {
					LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
					result = Integer.max(result, LCStuff[i][j]);
				} else
					LCStuff[i][j] = 0;
			}
		}
		return result;
	}

	/*
	 * Inroder to print it , find the element with max value and start tarversing
	 * array from that element and keep on moving i--,j-- i.e diagnally This way
	 * we'll keep on printing the longest common substring Stop when we reach an
	 * element with 0 value
	 * 
	 * 
	 * 
	 */
	// Function to extract the longest common substring using a populated
	// memoization table
	public static String extractLongestCommonSubstring(String str1, String str2, int[][] memo) {
		int m = str1.length();
		int n = str2.length();

		int maxLen = 0;
		int endIndex = 0;

		// Find the element with the maximum value in the memoization table
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (memo[i][j] > maxLen) {
					maxLen = memo[i][j];
					endIndex = i;
				}
			}
		}

		// Use StringBuilder to efficiently build the longest common substring
		StringBuilder longestCommonSubstringBuilder = new StringBuilder();
		int i = endIndex;
		while (i > 0) {
			longestCommonSubstringBuilder.append(str1.charAt(i - 1));
			i--;
		}

		return longestCommonSubstringBuilder.reverse().toString();
	}

}
