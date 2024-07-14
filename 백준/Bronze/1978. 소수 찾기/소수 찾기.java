import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (isPrime(number) && number != 1) answer++;
        }

        System.out.println(answer);
    }

    private static boolean isPrime(int number) {
        boolean prime = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                prime = false;
            }
        }

        return prime;
    }
}