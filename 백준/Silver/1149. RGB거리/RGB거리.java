import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            if (i==0) {
                dp[i][0] = red;
                dp[i][1] = green;
                dp[i][2] = blue;
                continue;
            }

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + red;
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + green;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + blue;
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (answer > dp[N-1][i]) answer = dp[N-1][i];
        }

        System.out.println(answer);
    }
}