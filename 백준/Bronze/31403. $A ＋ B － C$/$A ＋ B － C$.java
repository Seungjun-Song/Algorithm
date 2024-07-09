import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력 받기
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        scanner.close();

        // 수로 계산
        int resultNumber = A + B - C;

        // 문자열로 계산
        String resultString = String.valueOf(A) + String.valueOf(B);
        int resultStringNumber = Integer.parseInt(resultString) - C;

        // 결과 출력
        System.out.println(resultNumber);
        System.out.println(resultStringNumber);
    }
}