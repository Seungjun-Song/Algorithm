import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    private static int bfs(int start, int target) {
        if (start == target) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        boolean[] visited = new boolean[MAX + 1];
        visited[start] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int position = cur[0];
            int time = cur[1];

            if (position == target) {
                return time;
            }

            int[] nextPositions = {position + 1, position - 1, position * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= MAX && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, time + 1});
                }
            }
        }
        return -1;
    }
}