import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] map;
    private static final int[] dx = {-1, 0, 0, 1};
    private static final int[] dy = {0, -1, 1, 0};
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int r = 0;
        int c = 0;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int info = Integer.parseInt(st.nextToken());
                if(info==9) {
                    r = i;
                    c = j;
                    continue;
                }
                map[i][j] = info;
            }
        }

        bfs(r, c);

        System.out.println(answer);
    }

    private static void bfs(int r, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[2] != o2[2]) return Integer.compare(o1[2], o2[2]);
            else if(o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o1[1], o2[1]);
        });
        pq.add(new int[]{r, c, 0});
        boolean[][] visited = new boolean[N][N];
        int sharkSize = 2;
        int sharkAte = 0;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int time = current[2];

            if (sharkSize > map[x][y] && map[x][y] != 0) {
                sharkAte++;
                map[x][y] = 0;
                answer = time;

                if (sharkSize == sharkAte) {
                    sharkSize++;
                    sharkAte = 0;
                }

                pq.clear();
                visited = new boolean[N][N];
                visited[x][y] = true;
                pq.add(new int[]{x, y, time});
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && 0 <= ny && nx < N && ny < N && !visited[nx][ny] && sharkSize >= map[nx][ny]) {
                    visited[nx][ny] = true;
                    pq.add(new int[]{nx, ny, time + 1});
                }
            }
        }
    }
}