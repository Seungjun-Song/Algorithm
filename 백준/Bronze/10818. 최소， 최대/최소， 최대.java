import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int minNumber = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();

            if (a < minNumber) {
                minNumber = a;
            }

            if (a > maxNumber) {
                maxNumber = a;
            }
        }

        System.out.println(minNumber + " " + maxNumber);
    }
}