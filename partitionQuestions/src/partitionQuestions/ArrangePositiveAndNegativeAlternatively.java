package partitionQuestions;

public class ArrangePositiveAndNegativeAlternatively {
	public static void main(String[] args) {
		int[] arr = new int[] {7, -2, 6, -9, -4, -3, 5};
		arrange(arr, 0, arr.length - 1);
	}
	
	public static void arrange(int[] arr, int i, int j) {
	    int pIndex = partition(arr, i, j);
	    System.out.println("After partitioning:");
	    for (int num : arr) {
	        System.out.print(num + " ");
	    }
	    System.out.println();
	    
	    int posIndex = pIndex;
	    int negIndex = 0;
	    int[] rearrangedArray = new int[arr.length];
	    int k = 0;
	    while(posIndex < arr.length && negIndex < pIndex) {
	    	rearrangedArray[k++] = arr[posIndex];
	    	rearrangedArray[k++] = arr[negIndex];
	    	negIndex++;
	    	posIndex++;
	    }
	    while(posIndex < arr.length) {
	    	rearrangedArray[k++] = arr[posIndex];
	    	posIndex++;
	    }
	    
	    while(negIndex < pIndex) {
	    	rearrangedArray[k++] = arr[negIndex];
	    	negIndex++;
	    }
	    
	    System.out.println("After rearranging:");
	    for (int num : rearrangedArray) {
	        System.out.print(num + " ");
	    }
	    System.out.println();
	}


	public static int partition(int[] arr, int low, int high) {
		int i = low;
		for (int j = low; j <= high; j++) {
			if (arr[j] < 0) {
				swap(arr, i, j);
				i++;
			}
		}
		return i;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
