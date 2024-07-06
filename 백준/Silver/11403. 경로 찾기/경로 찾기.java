import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[][] graph;
    private static boolean[] visited;
    private static int[][] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            dfs(i, i, new boolean[n]);
        }

        printAnswer();
    }

    private static void dfs(int start, int current, boolean[] visited) {
        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph[current][i] == 1) {
                visited[i] = true;
                answer[start][i] = 1;
                dfs(start, i, visited);
            }
        }
    }

    private static void printAnswer() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}