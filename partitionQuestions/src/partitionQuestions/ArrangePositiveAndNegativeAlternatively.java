package partitionQuestions;

public class ArrangePositiveAndNegativeAlternatively {
	public static void main(String[] args) {
		int[] arr = new int[] {5, 0, 4, 8, -4, -7, -9, -2};
		arrange(arr, 0, arr.length - 1);
		for(int i : arr) {
			System.out.println(i + " ");
		}
	}
	
	public static void arrange(int[] arr, int i, int j) {
		int pIndex = partition(arr, i, j);
		int n = arr.length / 2;
		int posIndex = n;
		int negIndex = 0;
		while(posIndex < 2 * n && negIndex < n) {
			swap(arr, negIndex, posIndex);
			negIndex += 2;
			posIndex += 2;
		}
	}

	public static int partition(int[] arr, int low, int high) {
		int i = low - 1;
		for (int j = low; j <= high; j++) {
			if (arr[j] < 0) {
				i++;
				swap(arr, i, j);
			}
		}
		return i + 1;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
