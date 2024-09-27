import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String map = br.readLine();

        int answer = 0;
        for (int i = 1; i < N; i++) {
            if(map.charAt(i) == 'W' && map.charAt(i - 1) == 'E') answer++;
        }
        System.out.println(answer);
    }
}