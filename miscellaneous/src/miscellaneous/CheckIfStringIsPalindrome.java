package miscellaneous;

public class CheckIfStringIsPalindrome {
	public static void main(String[] args) {
		String s = "sottos";
		boolean isPalindrome = palindromeCheck(s);
		System.out.println(isPalindrome);
	}
	
	public static boolean palindromeCheck(String s) {
		int i = 0, j = 0;
		if(s.length() % 2 == 0) {
			j = s.length() / 2;
			i = j - 1;
		}
		else {
			j = s.length();
			i = j;
		}
		
		while(i >= 0 && j < s.length()) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i--;
			j++;
		}
		return true;
	}
}
