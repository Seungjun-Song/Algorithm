import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int answer = 0;
		answer += s.length()-s.replace("a", "").length();
		answer += s.length()-s.replace("e", "").length();
		answer += s.length()-s.replace("i", "").length();
		answer += s.length()-s.replace("o", "").length();
		answer += s.length()-s.replace("u", "").length();
		System.out.println(answer);
	}
}