package fibonacci;

public class Fibonacci {
	public int fibonacci(int n) {
		if (n < 0)
			return -1;
		if (n == 0 || n == 1)
			return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		int fib_len = 4;
		System.out.print("Fibonacci Series of " + fib_len + " numbers is: \n");
		for (int i = 0; i < fib_len; i++) {
			System.out.print(fibonacci.fibonacci(i) + " ");
		}
	}
}
  