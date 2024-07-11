package demo;

import java.util.HashSet;
import java.util.Set;

public class Test {

	//Merge strings alternatively : Input: word1 = "abc", word2 = "pqr" Output: "apbqcr"
	public static void main(String[] args) {
		String str = removeDuplicates("zvvozzzooo");
		System.out.println(str);
	}
	
	public static String removeDuplicates(String s) {
		Set<Character> set = new HashSet<>();
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(!set.contains(ch)) {
				result.append(ch);
				set.add(ch);
			}
		}
		return result.toString();
	}
}
