package test.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {
	//Input - a,b,f,f,g,s,d,d,t,  output- a,b,g,s,t   
	public static void main(String[] args) {
		char[] arr = {'a', 'b', 'f', 'f', 'g', 's', 'd', 'd', 't'};
		Map<Character, Integer> freqMap = new TreeMap<>();
		for(char c : arr) {
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
		}
		for(Map.Entry<Character, Integer> m : freqMap.entrySet()) {
			if(m.getValue() == 1)
				System.out.print(m.getKey() + " ");
		}
	}
}
