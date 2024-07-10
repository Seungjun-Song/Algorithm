import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        String s = String.valueOf((A * B * C));

        int[] arr = new int[10];
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - '0';
            arr[x]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}