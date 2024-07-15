import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] triangle = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (answer < triangle[N][i]) answer = triangle[N][i];
        }

        System.out.println(answer);
    }
}