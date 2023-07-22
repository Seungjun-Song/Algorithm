import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	static String vowel = "aeiou";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		while(!(s = br.readLine()).equals("end")) {
			if(checkVowel(s) && checkContinuityThree(s) && checkContinuityTwo(s))
				System.out.println("<" + s + "> is acceptable.");
			else
				System.out.println("<" + s + "> is not acceptable.");
		}
	}
	
	private static boolean checkVowel(String s) {
		if(s.contains("a")
				|| s.contains("e")
				|| s.contains("i")
				|| s.contains("o")
				|| s.contains("u")) return true;
		return false;
	}
	
	private static boolean checkContinuityThree(String s) {
		for(int i=0; i<s.length()-2; i++) {
			char c0 = s.charAt(i);
			char c1 = s.charAt(i+1);
			char c2 = s.charAt(i+2);
			String v0 = String.valueOf(c0);
			String v1 = String.valueOf(c1);
			String v2 = String.valueOf(c2);
			if(vowel.contains(v0) && vowel.contains(v1) && vowel.contains(v2)) {
				return false; 
			}
			if(!vowel.contains(v0) && !vowel.contains(v1) && !vowel.contains(v2)) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkContinuityTwo(String s) {
		for(int i=0; i<s.length()-1; i++) {
			if(s.charAt(i) == s.charAt(i+1) && s.charAt(i) != 'e' && s.charAt(i) != 'o')
				return false;
		}
		return true;
	}

}