import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            String a = String.valueOf(N % H == 0 ? H : N % H); // 층수
            String b = String.valueOf(N % H == 0 ? N / H : N / H + 1); // 호수

            if (b.length() < 2) System.out.println(a + "0" + b);
            else System.out.println(a + b);
        }
    }
}