import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] score = new int[N];
        int maxScore = 0;
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
            if (score[i] > maxScore) {
                maxScore = score[i];
            }
        }

        double answer = 0;
        for (int i = 0; i < N; i++) {
            answer += (double) (score[i] * 100) / maxScore;
        }
        System.out.println(answer / N);
    }
}