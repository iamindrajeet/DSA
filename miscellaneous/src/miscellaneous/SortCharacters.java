package miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortCharacters {
	public static void main(String[] args) {
		// Sample HashMap
		String str = "dddddaaaaabbbcccc";
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			map.put(String.valueOf(str.charAt(i)), map.getOrDefault(String.valueOf(str.charAt(i)), 0) + 1);
		}

		// Sort the HashMap by value in descending order
		LinkedHashMap<String, Integer> sortedMap = sortByValueDescending(map);

		// Print the sorted map
		System.out.println("Sorted HashMap (Descending Order):");
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		// StringBuilder to store the repeated keys
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				sb.append(entry.getKey());
			}
		}
		System.out.println(sb.toString());
	}

	public static LinkedHashMap<String, Integer> sortByValueDescending(HashMap<String, Integer> map) {
		// Convert HashMap to a list of Map.Entry objects
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				int compareValue = o2.getValue() - o1.getValue();
				if (compareValue != 0) {
					return compareValue;
				} else {
					// Compare the indices of characters in the original string
                    String key1 = o1.getKey();
                    String key2 = o2.getKey();
                    return key1.indexOf(key1.charAt(0)) - key2.indexOf(key2.charAt(0));
				}

			}
		});

		// Create a LinkedHashMap to store the sorted entries while maintaining order
		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
