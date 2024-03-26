package sort;

public class CountingSort {
	public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

   public static void countingSort(int[] arr) {
	   int max = findMax(arr);
	   int[] count = new int[max + 1];
	   // Count the frequency of each element
       for (int num : arr) {
           count[num]++;
       }

       // Modify the count array to store the position of each element in the sorted array
       for (int i = 1; i < count.length; i++) {
           count[i] += count[i - 1];
       }
	   
       int[] sortedArray = new int[arr.length];

       // Construct the sorted array
       for (int i = arr.length - 1; i >= 0; i--) {
           sortedArray[count[arr[i]] - 1] = arr[i];
           count[arr[i]]--;
       }

       // Copy the sorted array back to the original array
       System.arraycopy(sortedArray, 0, arr, 0, arr.length);
   }
   
   public static int findMax(int[] arr) {
	   int maxElement = Integer.MIN_VALUE;
	   for(int i : arr) {
		   if(i > maxElement) {
			   maxElement = i;
		   }
	   }
	   return maxElement;
   }
}
