package questions.recursion;

public class RecursionQuestions {

	public int productofArray(int A[], int N) {
		if (N <= 0)
			return 1;
		return (productofArray(A, N - 1) * A[N - 1]);
	}

	// find sum of number i.e from 0 to that number

	public int recursiveRange(int num) {
		if (num <= 0) {
			return 0;
		}
		return num + recursiveRange(num - 1);
	}

	public int fibonacci(int n) {
		if (n < 0) {
			return -1;
		}
		if (n == 0 || n == 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public String reverse(String str) {
		if (str.isEmpty())
			return str;
		// Calling Function Recursively
		return reverse(str.substring(1)) + str.charAt(0);
	}

	public boolean isPalindrome(String s) { // if length is 0 or 1 then String is palindrome
		if (s.length() == 0 || s.length() == 1)
			return true;
		if (s.charAt(0) == s.charAt(s.length() - 1))
			return isPalindrome(s.substring(1, s.length() - 1));
		return false;
	}

	public static char first(String str) {
		if (str.isEmpty()) {
			return ' ';
		}
		if (Character.isUpperCase(str.charAt(0))) {
			return str.charAt(0);
		} else {
			return first(str.substring(1, str.length()));
		}
	}

	public static String capitalizeWord(String str) {

		if (str.isEmpty()) {
			return str;
		}
		char chr = str.charAt(str.length() - 1);
		if (str.length() == 1) {
			return Character.toString(Character.toUpperCase(chr));
		}
		if ((str.substring(str.length() - 2, str.length() - 1).equals(" "))) {
			chr = Character.toUpperCase(chr);
		}
		return capitalizeWord(str.substring(0, str.length() - 1)) + Character.toString(chr);
	}
}
