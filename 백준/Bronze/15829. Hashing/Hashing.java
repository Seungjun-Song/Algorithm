import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        String S = sc.next();

        long answer = 0;
        long r = 31;
        long m = 1234567891;
        long r_pow = 1;

        for (int i = 0; i < L; i++) {
            int x = S.charAt(i) - 'a' + 1;
            answer = (answer + x * r_pow) % m;
            r_pow = (r_pow * r) % m;
        }

        System.out.println(answer);
    }
}