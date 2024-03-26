package sort;

public class Main {

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		SelectionSort selectionSort = new SelectionSort();
		InsertionSort insertionSort = new InsertionSort();
		MergeSort mergeSort = new MergeSort();
		QuickSort quickSort = new QuickSort();
		int[] arr = {-10, 5, 30, 15, -50, 6, 1};
		bubbleSort.bubbleSort(arr);
		bubbleSort.printArray(arr);
		System.out.println();
		selectionSort.selectionSort(arr);
		selectionSort.printArray(arr);
		System.out.println();
		insertionSort.insertionSort(arr);
		insertionSort.printArray(arr);
		System.out.println();
		mergeSort.mergeSort(arr, arr.length);
		mergeSort.printArray(arr);
		System.out.println();
		quickSort.quickSort(arr, 0, arr.length - 1);
		mergeSort.printArray(arr);
	}

}
