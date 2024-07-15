import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T_shirts = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            T_shirts[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] answer = new int[3];
        for (int i = 0; i < 6; i++) {
            answer[0] += (T_shirts[i] + T - 1) / T;
        }

        answer[1] = N / P;
        answer[2] = N % P;

        System.out.println(answer[0]);
        System.out.println(answer[1] + " " + answer[2]);
    }
}