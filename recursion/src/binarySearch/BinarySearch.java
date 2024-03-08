package binarySearch;

public class BinarySearch {

	public static int binarySearch(int arr[], int start, int end, int number) {
		if (start > end)
			return -1;
		int mid = start + (end - start) / 2;
		if (arr[mid] == number)
			return mid;
		else if (arr[mid] < number) {
			return binarySearch(arr, mid + 1, end, number);
		} else {
			return binarySearch(arr, start, mid - 1, number);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 3, 4, 5 };
		int result = binarySearch(arr, 0, arr.length - 1, 0);
		System.out.println(result);
	}
}
