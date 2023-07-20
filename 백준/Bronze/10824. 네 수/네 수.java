import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		String C = sc.next();
		String D = sc.next();
		A += B;
		C += D;
		System.out.println(Long.parseLong(A) + Long.parseLong(C));
	}

}