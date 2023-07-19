import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			String[] s = sc.next().split(",");
			System.out.println(Integer.parseInt(s[0]) + Integer.parseInt(s[1]));
		}

	}

}
