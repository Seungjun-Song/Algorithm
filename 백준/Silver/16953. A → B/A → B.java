import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = 0;
        while (B > A) {
            if (B % 2 == 0) {
                B = B / 2;
            } else {
                String s = String.valueOf(B);
                if (s.charAt(s.length() - 1) != '1') break;
                s = s.substring(0, s.length() - 1);
                B = Integer.parseInt(s);
            }
            answer++;
        }

        System.out.println(A == B ? answer + 1 : -1);
    }
}