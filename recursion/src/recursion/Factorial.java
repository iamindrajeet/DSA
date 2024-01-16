package recursion;

public class Factorial {
	public int factorial(int n) {
		if (n < 0)
			return -1;
		if (n == 0 || n == 1)
			return 1;

		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		int rec = factorial.factorial(4);
		System.out.println(rec);
	}
}
