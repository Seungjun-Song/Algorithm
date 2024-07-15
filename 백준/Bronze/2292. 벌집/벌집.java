import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int index = 1; // 1부터 시작 (벌집 중심)
        int number = 1; // 첫 번째 방

        while (index < N) {
            index += 6 * number; // 각 층마다 6의 배수로 방이 늘어남
            number++; // 다음 층으로 증가
        }

        System.out.println(number);
    }
}