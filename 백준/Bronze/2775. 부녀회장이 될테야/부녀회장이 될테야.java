import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[][] apart = new int[15][15];
        for (int i = 1; i <= 14; i++) {
            apart[0][i] = i;
        }

        for (int i = 0; i <= 14; i++) {
            apart[i][1] = 1;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 2; j <= 14; j++) {
                for (int k = j; k > 0; k--) {
                    apart[i][j] += apart[i - 1][k];
                }
            }
        }

        for (int i = 0; i < T; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(apart[k][n]);
        }
    }
}