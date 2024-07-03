import java.util.Scanner;

public class Main {

    private static final int MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] a = new int[10];
        int[] b = new int[10];

        for (int i = 1; i < 10; i++) {
            a[i] = 1;
        }

        boolean flag = true;
        for (int i = 0; i < N - 1; i++) {
            if (flag) {
                // a의 배열에 값이 잇는 경우
                for (int j = 0; j < 10; j++) {
                    if (a[j] > 0) {
                        if (j - 1 >= 0) {
                            b[j - 1] += a[j] % MOD;
                        }

                        if (j + 1 < 10) {
                            b[j + 1] += a[j] % MOD;
                        }
                        a[j] = 0;
                    }
                }
                flag = false;
            } else {
                // b의 배열에 값이 있는 경우
                for (int j = 0; j < 10; j++) {
                    if (b[j] > 0) {
                        if (j - 1 >= 0) {
                            a[j - 1] += b[j] % MOD;
                        }

                        if (j + 1 < 10) {
                            a[j + 1] += b[j] % MOD;
                        }
                        b[j] = 0;
                    }
                }
                flag = true;
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += a[i];
            answer += b[i];
        }
        System.out.println(answer % MOD);
    }
}

//방법 1.
//0~9 배열을 만들고 1~9 인덱스에 1을 채운다.
//비어 있는 배열을 만든다.
//인덱스가 있는 배열을 탐색하며 비어 있는 배열에 값을 갱신한다.
//
//방법 2.
//for문으로 1~9를 순회하며
//1에서 가지를 뻗치며 몇개가 나오는지 센다.
//2에서 가지를 뻗치며 몇개가 나오는지 센다. (반복)
//총 갯수를 센다.