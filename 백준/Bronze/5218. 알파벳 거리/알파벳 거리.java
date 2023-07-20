import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// A = 65 Z = 90
		for(int tc=0; tc<T; tc++) {
			String a = sc.next();
			String b = sc.next();
			
			int x, y;
			String answer = "Distances: ";
			for(int i=0; i<a.length(); i++) {
				x = (int)a.charAt(i);
				y = (int)b.charAt(i);
				if(x<=y) answer += y-x + " ";
				else answer += y+26-x + " ";
			}
			System.out.println(answer);
		}
	}

}