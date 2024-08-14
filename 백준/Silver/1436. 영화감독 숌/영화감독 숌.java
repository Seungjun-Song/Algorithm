import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String number = String.valueOf(i);
            if (number.contains("666")) {
                count++;
            }

            if (count == N) {
                System.out.println(i);
                break;
            }
        }
    }
}

// 1 : 666
// 2 : 1666
// 3 : 2666
// 4 : 3666
// 5 : 4666
// 6 : 5666
// 7 : 6660
// 8 : 6661
// 9 : 6662
// 10 : 6663
// 11 : 6664
// 12 : 6665
// 13 : 6666
// 14 : 6667
// 15 : 6668