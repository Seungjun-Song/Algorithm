import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (N > 1) {
            int newSize = N / 2;
            int[][] square = new int[newSize][newSize];

            for (int i = 0; i < newSize; i++) {
                for (int j = 0; j < newSize; j++) {
                    int maxNumber = Integer.MIN_VALUE;
                    int secondNumber = Integer.MIN_VALUE;

                    for (int k = 0; k < 2; k++) {
                        for (int l = 0; l < 2; l++) {
                            int number = arr[i * 2 + k][j * 2 + l];
                            if (maxNumber <= number) {
                                secondNumber = maxNumber;
                                maxNumber = number;
                            } else if (secondNumber <= number) {
                                secondNumber = number;
                            }
                        }
                    }

                    square[i][j] = secondNumber;
                }
            }
            arr = square;
            N = newSize;
        }

        System.out.println(arr[0][0]);
    }
}