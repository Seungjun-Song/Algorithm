import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String pattern[] = sc.next().split("\\*");
		
		for(int i=0; i<N; i++) {
			String s = sc.next();
			
			if(pattern[0].length()+pattern[1].length() > s.length()) {
				System.out.println("NE");
				continue;
			}
			
			String start = s.substring(0, pattern[0].length());
			String end = s.substring(s.length()-pattern[1].length(), s.length());
			
			if(pattern[0].equals(start) && pattern[1].equals(end)) {
				System.out.println("DA");
			} else System.out.println("NE");
			
		}
	}
}