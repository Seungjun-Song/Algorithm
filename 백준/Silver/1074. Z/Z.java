import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = 0;
        double square;
        double line;
        double row = Math.pow(2, N) / 2;
        double col = Math.pow(2, N) / 2;

        while (N > 0) {
            square = Math.pow(2, N) / 2;
            N--;
            line = Math.pow(2, N) / 2;
            if (r < row && c < col) { // 좌측 상단일 때
                row -= line;
                col -= line;
            } else if (r < row && c >= col) { // 우측 상단일 때
                row -= line;
                col += line;
                answer += (int) (square * square);
            } else if (r >= row && c < col) { // 좌측 하단일 때
                row += line;
                col -= line;
                answer += (int) (square * square * 2);
            } else { // 우측 하단일 때
                row += line;
                col += line;
                answer += (int) (square * square * 3);
            }
        }

        System.out.println(answer);
    }
}