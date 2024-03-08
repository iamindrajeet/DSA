package sort;

public class SelectionSort {

	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minimumIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minimumIndex])
					minimumIndex = j;
			}
			if (minimumIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minimumIndex];
				arr[minimumIndex] = temp;
			}
		}
	}

	public void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
