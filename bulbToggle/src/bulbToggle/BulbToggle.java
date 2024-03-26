package bulbToggle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BulbToggle {

	static int n = 1000000;
	static int q = 10000;
	static List<Integer> bulbs = new ArrayList<>();
	static List<Integer> bulbs2 = new ArrayList<>();

	public static void main(String[] args) {
		Random random = new Random();

		for (int i = 0; i < n; i++) {
			bulbs.add(random.nextInt(2));
			bulbs2.add(bulbs.get(i));
		}

		List<Pair<Integer, Integer>> queries = new ArrayList<>();
		for (int i = 0; i < q; i++) {
			int l = random.nextInt(n);
			int m = random.nextInt(n - l) + l;
			queries.add(new Pair<>(l, m));
		}

		bulbToggle(bulbs, queries);
		bulbTogglePrefixSum(bulbs2, queries);
	}

	// brute force approach -- T.C - O(n * q)
	static void bulbToggle(List<Integer> bulbs, List<Pair<Integer, Integer>> queries) {
		long startTime = System.currentTimeMillis();
		for (Pair<Integer, Integer> query : queries) {
			int l = query.getKey();
			int m = query.getValue();
			for (int i = l; i <= m; i++) {
				bulbs.set(i, 1 - bulbs.get(i));
			}
		}
		System.out
				.println("Time taken by bulbToggle is " + (System.currentTimeMillis() - startTime) + " milliseconds.");
		System.out.println("Total lit bulbs: " + bulbs.stream().mapToInt(Integer::intValue).sum());
	}

	// Efficient Approach using Prefix Sum -- T.C - O(n + q)
	static void bulbTogglePrefixSum(List<Integer> bulbs, List<Pair<Integer, Integer>> queries) {
		long startTime = System.currentTimeMillis();
		int[] diffArray = new int[n + 1];

		for (Pair<Integer, Integer> query : queries) {
			int l = query.getKey();
			int m = query.getValue();
			diffArray[l]++;
			diffArray[m + 1]--;
		}

		int[] prefixArray = new int[n];
		prefixArray[0] = diffArray[0];
		for (int i = 1; i < n; i++) {
			prefixArray[i] = prefixArray[i - 1] + diffArray[i];
		}

		for (int i = 0; i < prefixArray.length; i++) {
			if (prefixArray[i] % 2 != 0) {
				bulbs.set(i, 1 - bulbs.get(i));
			}
		}
		System.out.println(
				"Time taken by bulbTogglePrefixSum is " + (System.currentTimeMillis() - startTime) + " milliseconds.");
		System.out.println("Total lit bulbs: " + bulbs.stream().mapToInt(Integer::intValue).sum());
	}

	static class Pair<K, V> {
		private final K key;
		private final V value;

		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
	}
}
