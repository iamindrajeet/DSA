package miscellaneous;

public class SpecialPairOfScores {
	static long specialPairs = 0;

	public static void main(String[] args) {
		int[] arr = new int[] { 8, 4, 2, 1, 5, 3 };
		// Calculate the total number of special pairs
		countSpecialPairs(arr, arr.length);
		System.out.println(specialPairs);
	}

	public static void countSpecialPairs(int[] arr, int n) {
		if (n < 2)
			return;
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = arr[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = arr[i];
		}

		countSpecialPairs(l, mid);
		countSpecialPairs(r, n - mid);
		merge(arr, l, r, mid, n - mid);
	}

	public static void merge(int[] arr, int[] l, int[] r, int left, int right) {
		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] > r[j]) {
				specialPairs += r.length - j;
				arr[k++] = l[i++];
			} else {
				arr[k++] = r[j++];
			}
		}
		while (i < left) {
			arr[k++] = l[i++];
		}

		while (j < right) {
			arr[k++] = r[j++];
		}
	}
}
