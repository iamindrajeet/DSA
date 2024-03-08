package recursion;

public class Factorial {
	public int factorial(int n) {
		if (n < 0)
			return -1;
		if (n == 0 || n == 1)
			return 1;

		int temp = factorial(n-1);
		int ans = n * temp;
		return ans;
	}

	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		int rec = factorial.factorial(5);
		System.out.println(rec);
	}
}
