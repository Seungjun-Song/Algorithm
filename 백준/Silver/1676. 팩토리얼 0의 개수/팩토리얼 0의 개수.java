import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        while (N >= 5) {
            answer += N / 5;
            N /= 5;
        }

        System.out.println(answer);
    }
}

// 1! = 1
// 2! = 2
// 3! = 6
// 4! = 24
// 5! = 120
// 6! = 720
// 7! = 5040
// 8! = 40320
// 9! = 362880
// 10! = 3628800
// 11! = 39,916,800
// 12! = 479,001,600
// 13! = 6,227,020,800
// 14! = 87,178,291,200
// 15! = 1,307,674,368,000
// 16! = 20,922,789,888,000
// 17! = 355,687,428,096,000
// 18! = 6,402,373,705,728,000