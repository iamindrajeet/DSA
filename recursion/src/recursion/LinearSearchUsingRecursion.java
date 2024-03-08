package recursion;

import java.util.ArrayList;

public class LinearSearchUsingRecursion {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 4, 5, 6 };
		boolean isPresent = isPresent(arr, 1, 0);
		System.out.println(isPresent);
		int index = findIndex(arr, 6, 0);
		System.out.println(index);
		int[] arr1 = { 1, 2, 4, 4, 5, 6 };
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> result = findAllIndex(arr1, 4, 0, list);
		System.out.println(result);
		ArrayList<Integer> result1 = findAllIndexUsingArrayListInFunctionBody(arr1, 4, 0);
		System.out.println(result1);
	}

	public static boolean isPresent(int[] arr, int target, int index) {
		if (index > arr.length - 1)
			return false;
		return arr[index] == target || isPresent(arr, target, index + 1);
	}

	public static int findIndex(int[] arr, int target, int index) {
		if (index > arr.length - 1)
			return -1;
		if (arr[index] == target)
			return index;
		else
			return findIndex(arr, target, index + 1);
	}

	public static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list) {
		if (index > arr.length - 1)
			return list;

		if (arr[index] == target)
			list.add(index);
		return findAllIndex(arr, target, index + 1, list);
	}

	public static ArrayList<Integer> findAllIndexUsingArrayListInFunctionBody(int[] arr, int target, int index) {
		ArrayList<Integer> list = new ArrayList<>();

		if (index > arr.length - 1)
			return list;

		if (arr[index] == target)
			list.add(index);

		ArrayList<Integer> newList = findAllIndexUsingArrayListInFunctionBody(arr, target, index + 1);
		list.addAll(newList);
		return list;
	}
}
