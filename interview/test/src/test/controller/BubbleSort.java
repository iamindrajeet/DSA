package test.controller;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {6,3,1,5,2,4};
		int n = arr.length;
		bubbleSort(arr, n);
		printArray(arr, n);
	}
	
	public static void bubbleSort(int arr[], int n) {
		int i, j, temp;
		boolean swapped;
		for(i = 0; i < n - 1; i++) {
			swapped = false;
			for(j = 0; j < n - i - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					//swap 
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if(swapped == false)
				break;
		}
	}
	
	public static void printArray(int[] arr, int n) {
		int i;
		for(i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
