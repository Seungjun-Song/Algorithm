import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<int[]> queue = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                queue.add(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            int answer = 0;
            while (!queue.isEmpty()) {
                int[] front = queue.poll();
                boolean isMax = false;

                for (int[] q : queue) {
                    if (q[1] > front[1]) {
                        isMax = true;
                        break;
                    }
                }

                if (isMax) {
                    queue.add(front);
                } else {
                    answer++;
                    if (front[0] == M) {
                        System.out.println(answer);
                        break;
                    }
                }
            }
        }
    }
}