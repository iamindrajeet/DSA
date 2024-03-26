package sort;

public class QuickSort {
	public void quickSort(int[] arr, int low, int high) {
		if(low >= high)
			return;
		int partitonIndex = partition(arr, low, high);
		quickSort(arr, low, partitonIndex - 1);
		quickSort(arr, partitonIndex + 1, high);
	}

	public int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low, j = 0;
		for(j = low; j < high; j++) {
			if(arr[j] < pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, j);
		return i;
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
