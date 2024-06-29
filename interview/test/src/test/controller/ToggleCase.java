package test.controller;

public class ToggleCase {
	public static void main(String[] args) {
		String str = "I Am a StrINg";
		StringBuilder result = new StringBuilder();
		
		for(char c : str.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
                result.append((char) (c - ('a' - 'A')));
            } else if (c >= 'A' && c <= 'Z') {
                result.append((char) (c + ('a' - 'A')));
            } else {
                result.append(c); // Keep the character as is if it's not a letter
            }
		}
		System.out.println(result.toString());
	}
}
