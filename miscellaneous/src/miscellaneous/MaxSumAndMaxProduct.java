package miscellaneous;

public class MaxSumAndMaxProduct {
	public static void main(String[] args) {
		int[] arr = new int[] { -1, 2, 3, -4, 5 };
		int sum = findSum(arr);
		System.out.println(sum);
		Double product = findProduct(arr);
		System.out.println(product);
		
	}

	public static int findSum(int[] arr) {
		int i = 0;
		int maxSum = Integer.MIN_VALUE, maxSoFar = 0;
		int start = 0, startIndex = 0, endIndex = 0;
		while (i < arr.length) {
			if (maxSoFar == 0)
				start = i;
			maxSoFar = maxSoFar + arr[i];
			if (maxSoFar > maxSum) {
				maxSum = maxSoFar;
				startIndex = start;
				endIndex = i;
			}
			i++;
			if (maxSoFar < 0)
				maxSoFar = 0;
		}
		System.out.println(startIndex + " " + endIndex);
		return maxSum;
	}

	public static Double findProduct(int[] arr) {
		int count = 0;
		Double maxProduct = Double.MIN_VALUE, maxSoFar = 0.0;
		int start = 0, startIndex = 0, endIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0)
				count++;
		}
		for (int i = 0; i < arr.length; i++) {
			maxSoFar += Math.log(Math.abs(arr[i]));
			if (maxSoFar > maxProduct) {
				maxProduct = maxSoFar;
				startIndex = start;
				endIndex = i;
			}
			if (maxSoFar < 0)
				maxSoFar = 0.0;
		}
		System.out.println(startIndex + " " + endIndex);
		if (count % 2 != 0)
			return -1 * Math.exp(maxProduct);
		else
			return Math.exp(maxProduct);
	}

}
