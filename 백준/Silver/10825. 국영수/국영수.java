import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[][] score = new String[N][4];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) {
                score[i][j] = st.nextToken();
            }
        }

        Arrays.sort(score, (a, b) -> {
            int korean1 = Integer.parseInt(a[1]);
            int korean2 = Integer.parseInt(b[1]);
            int english1 = Integer.parseInt(a[2]);
            int english2 = Integer.parseInt(b[2]);
            int math1 = Integer.parseInt(a[3]);
            int math2 = Integer.parseInt(b[3]);
            if(korean1 == korean2) {
                if(english1 == english2) {
                    if(math1 == math2) {
                        return a[0].compareTo(b[0]);
                    }
                    return math2 - math1;
                }
                return english1 - english2;
            }
            return korean2 - korean1;
        });

        for(int i=0; i<N; i++) {
            System.out.println(score[i][0]);
        }
    }
}