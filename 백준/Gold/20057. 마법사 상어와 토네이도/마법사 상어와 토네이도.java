import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] matrix;
    private static int[][] dx = {{-1, 1, -1, 1, -2, 2, -1, 1, 0, 0}, {1, 1, 0, 0, 0, 0, -1, -1, 2, 1}
                                ,{-1, 1, -1, 1, -2, 2, -1, 1, 0, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, -2, -1}};
    private static int[][] dy = {{-1, -1, 0, 0, 0, 0, 1, 1, -2, -1}, {-1, 1, -1, 1, -2, 2, -1, 1, 0, 0}
                                ,{1, 1, 0, 0, 0, 0, -1, -1, 2, 1}, {-1, 1, -1, 1, -2, 2, -1, 1, 0, 0}};
    private static int[] weight = {10, 10, 7, 7, 2, 2, 1, 1, 5};
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation(N/2, N/2, "left", 1);

        System.out.println(answer);
    }

    private static void simulation(int r, int c, String direction, int len) {
        if(len==N) {
            for(int i=1; i<len; i++) {
                if(c-i>=0)
                    move(r, c-i, 0);
            }
            return;
        }

        if(direction.equals("left")) {
            for(int i=1; i<=len; i++) {
                if(c-i>=0)
                    move(r, c-i, 0);
            }
            simulation(r, c-len, "down", len);
        } else if(direction.equals("down")) {
            for(int i=1; i<=len; i++) {
                if(r+i<N)
                    move(r+i, c, 1);
            }
            simulation(r+len, c, "right", len+1);
        } else if(direction.equals("right")) {
            for(int i=1; i<=len; i++) {
                if(c+i<N)
                    move(r, c+i, 2);
            }
            simulation(r, c+len, "up", len);
        } else if(direction.equals("up")) {
            for(int i=1; i<=len; i++) {
                if(r-i>=0)
                    move(r-i, c, 3);
            }
            simulation(r-len, c, "left", len+1);
        }
    }

    private static void move(int r, int c, int d) {
        int temp = 0;
        int nx = 0;
        int ny = 0;

        for(int i=0; i<10; i++) {
            nx = r + dx[d][i];
            ny = c + dy[d][i];
            if(i==9) break;

            int value = (int) Math.floor((double) matrix[r][c] / 100 * weight[i]);
            temp += value;

            if(0<=nx && nx<N && 0<=ny && ny<N && value>0) {
                matrix[nx][ny] += value;
            } else {
                answer += value;
            }
        }

        matrix[r][c] -= temp;
        if(0<=nx && nx<N && 0<=ny && ny<N) {
            matrix[nx][ny] += matrix[r][c];
        } else {
            answer += matrix[r][c];
        }
        matrix[r][c] = 0;
    }
}