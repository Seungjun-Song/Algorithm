import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        String S = sc.next();

        int answer = 0;
        for (int i = 0; i < L; i++) {
            int x = S.charAt(i) - 'a' + 1;
            answer += (int) (x * Math.pow(31, i));
        }

        System.out.println(answer);
    }
}