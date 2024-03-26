package miscellaneous;

public class PineappleAndMangoes {
	public static void main(String[] args) {
		String s = "PMPP";
		int index = findIndex(s);
		System.out.println(index);
	}

	public static int findIndex(String s) {
		int mangosCount = 0, pineapplesCount = 0;
		int n = s.length();
		for(char c : s.toCharArray()) {
			if(c == 'M')
				mangosCount++;
			else
				pineapplesCount++;
		}
		if((mangosCount == 1 && n == 1) || (pineapplesCount == 1 && n == 1))
				return -1;
		
		int myMangosCount = 0, myPineapplesCount = 0;
		int myFriendsMangosCount = 0, myFriendsPineapplesCount = 0;
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == 'M') {
				myMangosCount++;
			}else {
				myPineapplesCount++;
			}
			myFriendsMangosCount = mangosCount - myMangosCount;
			myFriendsPineapplesCount = pineapplesCount - myPineapplesCount;
			System.out.print(myFriendsMangosCount + " " + myFriendsPineapplesCount);
			System.out.println();
			if(i == n - 1)
				return -1;
			if(myFriendsMangosCount != myMangosCount && myFriendsPineapplesCount != myPineapplesCount) {
				return i + 1;
			}
		}
		return -1;
	}
}

