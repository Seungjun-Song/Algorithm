import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		String s[] = new String[5];
		for(int i=0; i<5; i++) {
			s[i] = sc.next();
		}
		
		String answer = "";
		for(int i=0; i<5; i++) {
			if(s[i].contains("FBI")) answer += (i+1) + " "; 
		}
		
		if(answer.length() == 0) System.out.println("HE GOT AWAY!");
		else System.out.println(answer);
		
	}
	
}