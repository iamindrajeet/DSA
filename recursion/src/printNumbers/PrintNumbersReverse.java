package printNumbers;

public class PrintNumbersReverse {
public static void main(String[] args) {
	printReverse(5);
}

public static void printReverse(int n) {
	if(n == 0)
		return;
	printReverse(n-1);
	System.out.print(n + " ");
}
}
