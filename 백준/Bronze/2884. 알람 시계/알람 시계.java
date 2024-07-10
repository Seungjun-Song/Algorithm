import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 값을 받습니다.
        int H = scanner.nextInt();
        int M = scanner.nextInt();

        // 45분을 빼줍니다.
        M -= 45;

        // 분이 음수가 되면 시간에서 1을 빼주고, 분에 60을 더해줍니다.
        if (M < 0) {
            M += 60;
            H -= 1;
        }

        // 시간이 음수가 되면 23으로 바꿔줍니다.
        if (H < 0) {
            H = 23;
        }

        // 결과를 출력합니다.
        System.out.println(H + " " + M);

        scanner.close();
    }
}