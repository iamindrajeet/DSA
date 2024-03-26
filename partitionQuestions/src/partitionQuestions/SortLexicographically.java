package partitionQuestions;

import java.util.Arrays;
import java.util.Comparator;

public class SortLexicographically {
	public static void main(String[] args) {
		String[] arr = new String[] {"google", "apple", "eat", "maple", "beat"};
		//sortLexicographically(arr);
		groupRhymingWords(arr);
//		for (String s : arr) {
//			System.out.println(s + " ");
//		}
		
		int[] nums = new int[] {9, 83, 98, 67, 121, 5};
		findLargestNumber(nums);
		
	}

	public static void sortLexicographically(String[] arr) {
		Arrays.sort(arr, (a, b) -> b.compareTo(a));

	}
	
	public static void groupRhymingWords(String[] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			arr[i] = sb.reverse().toString();
			sb.delete(0, sb.length());
		}
		Arrays.sort(arr, (a, b) -> a.compareTo(b));
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			arr[i] = sb.reverse().toString();
			sb.delete(0, sb.length());
		}
	}
	
	public static void findLargestNumber(int[] arr) {
		String[] str = new String[arr.length];
		for(int i = 0; i < arr.length; i++) {
			str[i] = String.valueOf(arr[i]);
		}
		for (String s : str) {
			System.out.print(s + " ");
		}
		
		Arrays.sort(str, (a, b) -> (b).compareTo(a));
		
		StringBuilder sb = new StringBuilder();
		for(String s : str) {
			sb.append(s);
		}
		System.out.println(sb.toString());
		for (String s : str) {
			System.out.print(s + " ");
		}
		
	}

}
