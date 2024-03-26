package sort;

public class InsertionSort {

	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i], j = i;
			while(j > 0 && arr[j - 1] > key) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = key;
		}
	}

	public void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
