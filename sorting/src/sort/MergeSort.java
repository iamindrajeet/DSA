package sort;

public class MergeSort {

	public void mergeSort(int[] arr, int n) {
		if (n < 2)
			return;
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = arr[i];
		}

		for (int i = mid; i < n ; i++) {
			r[i - mid] = arr[i];
		}

		mergeSort(l, mid);
		mergeSort(r, n - mid);
		merge(arr, l, r, mid, n - mid);
	}

	private void merge(int[] arr, int[] l, int[] r, int left, int right) {
		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				arr[k] = l[i];
				k++;
				i++;
			} else {
				arr[k] = r[j];
				k++;
				j++;
			}
		}
		while (i < left) {

			arr[k] = l[i];
			k++;
			i++;
		}

		while (j < right) {

			arr[k] = r[j];
			k++;
			j++;
		}
	}
	
	public void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
