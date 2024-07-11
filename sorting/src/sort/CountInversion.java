package sort;

/*

The inversion count of an array denotes how far is the array from being sorted.

If the array is sorted, inversion count is 0. If the array is sorted in reverse order, the inversion count is maximum.

More formally, the inversion count of an array A is the number of pairs (i, j) such A[i] < A[j] and i > j.

Example
Lets take the following array:
8, 4, 1, 2

This array has an inversion count of 5.
(8, 4), (8, 1), (8, 2), (4, 1), (4, 2)

Given an array A, calculate the inversion count of the array.
*/

// We are solving this problem using modified merge sort
public class CountInversion {

    public static int mergeSortAndCount(int[] arr, int n) {
        if (n < 2) {
            return 0;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }

        int leftInversions = mergeSortAndCount(left, mid);
        int rightInversions = mergeSortAndCount(right, n - mid);
        int splitInversions = mergeAndCount(arr, left, right, mid, n - mid);

        return leftInversions + rightInversions + splitInversions;
    }

    private static int mergeAndCount(int[] arr, int[] left, int[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;
        int inversions = 0;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                inversions += (leftSize - i); // Count inversions
            }
        }

        while (i < leftSize) {
            arr[k++] = left[i++];
        }
        while (j < rightSize) {
            arr[k++] = right[j++];
        }

        return inversions;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 2};
        int inversions = mergeSortAndCount(arr, arr.length);
        System.out.println("Number of inversions: " + inversions);
        System.out.print("Sorted array: ");
        printArray(arr);
    }
}
