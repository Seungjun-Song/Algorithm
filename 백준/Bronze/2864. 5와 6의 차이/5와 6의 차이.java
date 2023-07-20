import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int maxValue, minValue;
		
		s1 = s1.replaceAll("6", "5");
		s2 = s2.replaceAll("6", "5");
		minValue = Integer.parseInt(s1) + Integer.parseInt(s2);
		
		s1 = s1.replaceAll("5", "6");
		s2 = s2.replaceAll("5", "6");
		maxValue = Integer.parseInt(s1) + Integer.parseInt(s2);
		
		System.out.print(minValue + " ");
		System.out.print(maxValue);
	}
}