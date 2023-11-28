import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N, H;
    static int[][][] warehouse;
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        warehouse = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    warehouse[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int days = ripenTomatoes();
        System.out.println(days);
    }

    private static int ripenTomatoes() {
        Queue<int[]> queue = new LinkedList<>();

        // Enqueue all initial ripe tomatoes
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (warehouse[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k, 0});
                    }
                }
            }
        }

        int days = 0;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int i = pos[0], j = pos[1], k = pos[2], currentDay = pos[3];

            days = Math.max(days, currentDay);

            for (int d = 0; d < 6; d++) {
                int ni = i + dz[d];
                int nj = j + dx[d];
                int nk = k + dy[d];

                if (isValid(ni, nj, nk) && warehouse[ni][nj][nk] == 0) {
                    warehouse[ni][nj][nk] = 1; // Mark as ripe
                    queue.offer(new int[]{ni, nj, nk, currentDay + 1});
                }
            }
        }

        // Check if there are any unripe tomatoes left
        if (hasUnripeTomatoes()) {
            return -1; // Some tomatoes remain unripe
        }

        return days;
    }

    private static boolean isValid(int i, int j, int k) {
        return i >= 0 && i < H && j >= 0 && j < N && k >= 0 && k < M;
    }

    private static boolean hasUnripeTomatoes() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (warehouse[i][j][k] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}