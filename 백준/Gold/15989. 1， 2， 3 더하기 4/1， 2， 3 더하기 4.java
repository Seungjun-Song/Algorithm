import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] dp = new int[10001][4];

            dp[1][1] = 1; // 1
            dp[2][1] = 1; // 1 + 1
            dp[2][2] = 1; // 2
            dp[3][1] = 1; // 1 + 1 + 1
            dp[3][2] = 1; // 1 + 2
            dp[3][3] = 1; // 3

            for (int i = 4; i <= n; i++) {
                dp[i][1] = dp[i - 1][1];
                dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
                dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
            }

            int answer = dp[n][1] + dp[n][2] + dp[n][3];
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}