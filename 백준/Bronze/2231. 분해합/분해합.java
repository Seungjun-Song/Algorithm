import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int sum, answer = 0;
        boolean flag = false;
        for (int i = 1; i <= 10000000; i++) {
            sum = i;
            int x = i;
            while (x / 10 > 0) {
                sum += x % 10;
                x /= 10;
            }
            sum += x;

            if (sum == N) {
                flag = true;
                answer = i;
                break;
            }
        }

        if (flag) {
            System.out.println(answer);
        } else {
            System.out.println(0);
        }
    }
}