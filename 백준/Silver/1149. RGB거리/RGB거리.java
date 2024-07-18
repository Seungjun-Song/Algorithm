import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 3; i++) {
            dp[1][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                int x = Integer.parseInt(st.nextToken());

                if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][2] + x, dp[i - 1][3] + x);
                } else if (j == 2) {
                    dp[i][j] = Math.min(dp[i - 1][1] + x, dp[i - 1][3] + x);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][1] + x, dp[i - 1][2] + x);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= 3; i++) {
            answer = Math.min(answer, dp[N][i]);
        }
        System.out.println(answer);
    }
}