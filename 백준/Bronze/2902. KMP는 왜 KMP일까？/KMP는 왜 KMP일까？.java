import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String answer = "";
		for(char c : s.toCharArray()) {
			if(65<=(int)c && (int)c<=90) {
				answer += c;
			}
		}
		System.out.println(answer);
	}

}