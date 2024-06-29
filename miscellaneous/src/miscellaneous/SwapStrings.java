package miscellaneous;

public class SwapStrings {
	public static void main(String[] args) {
		String s1 = "Indra";
		String s2 = "Singh";
		s1 = String.join("-", s1, s2);
		s2 = s1.split("-")[0];
		s1 = s1.split("-")[1];
		System.out.println(s2);
		System.out.println(s1);
		
	}
}
