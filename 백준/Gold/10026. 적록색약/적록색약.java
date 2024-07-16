import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int N;
    private static int[][] grid;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = s.charAt(j) - '0';
            }
        }

        int[] answer = new int[2];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    redGreenMedicine(i, j, grid[i][j]);
                    answer[0]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 23) grid[i][j] = 34;
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    redGreenMedicine(i, j, grid[i][j]);
                    answer[1]++;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

    // color 0 : 빨강, color 1 : 초록, color 2 : 파랑
    public static void redGreenMedicine(int x, int y, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, color});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curColor = cur[2];
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny] && grid[nx][ny] == curColor) {
                    queue.add(new int[]{nx, ny, curColor});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}