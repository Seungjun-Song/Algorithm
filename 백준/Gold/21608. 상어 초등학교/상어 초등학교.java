import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] map;
    private static Queue<Integer> q = new LinkedList<>();
    private static HashMap<Integer, List<Integer>> realation = new HashMap<>();
    private static final int dx[] = {-1, 0, 1, 0};
    private static final int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N*N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            q.add(student);

            realation.put(student, new ArrayList<>());
            for (int j = 0; j < 4; j++) {
                realation.get(student).add(Integer.parseInt(st.nextToken()));
            }
        }

        while (!q.isEmpty()) {
            int student = q.poll();
            int[][] temp = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[i][j] = map[i][j];
                }
            }

            int maxLike = -1;
            int maxEmpty = -1;
            PriorityQueue<int[]> candidates = new PriorityQueue<>((o1, o2) -> {
                if (o1[2] != o2[2]) return Integer.compare(o2[2], o1[2]);
                else if (o1[3] != o2[3]) return Integer.compare(o2[3], o1[3]);
                else if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
                else return Integer.compare(o1[1], o2[1]);
            });

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int likeCount = 0;
                    int emptyCount = 0;
                    if (map[i][j] == 0) {
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if (0 <= nx && 0 <= ny && nx < N && ny < N) {
                                if (realation.containsKey(student) && realation.get(student).contains(map[nx][ny])) likeCount++;
                                else if (map[nx][ny] == 0) emptyCount++;
                            }
                        }
                        candidates.add(new int[]{i, j, likeCount, emptyCount});
                    }
                }
            }

            int[] chosen = candidates.poll();
            int r = chosen[0];
            int c = chosen[1];
            map[r][c] = student;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (0 <= nx && 0 <= ny && nx < N && ny < N) {
                        if (map[i][j] != 0 && realation.containsKey(map[i][j]) && realation.get(map[i][j]).contains(map[nx][ny])) {
                            sum++;
                        }
                    }
                }
                switch (sum) {
                    case 1:
                        answer += 1;
                        break;
                    case 2:
                        answer += 10;
                        break;
                    case 3:
                        answer += 100;
                        break;
                    case 4:
                        answer += 1000;
                        break;
                }
            }
        }

        System.out.println(answer);
    }
}