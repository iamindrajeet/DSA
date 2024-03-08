package recursion;

public class CheckArrayIsSortedOrNot {
	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 4, 5, 6 };
		boolean result = isSorted(arr, 0);
		System.out.println(result);
	}

	public static boolean isSorted(int[] arr, int index) {
		if (index == arr.length - 1)
			return true;
		return arr[index] < arr[index + 1] && isSorted(arr, index + 1);
	}
}
