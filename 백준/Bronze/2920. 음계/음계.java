import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] notes = new int[8];

        // 8개의 숫자를 입력받아 배열에 저장합니다.
        for (int i = 0; i < 8; i++) {
            notes[i] = scanner.nextInt();
        }

        // 초기 상태를 mixed로 설정합니다.
        String result = "mixed";

        // 오름차순 여부 확인
        boolean ascending = true;
        for (int i = 0; i < 7; i++) {
            if (notes[i] > notes[i + 1]) {
                ascending = false;
                break;
            }
        }

        // 내림차순 여부 확인
        boolean descending = true;
        for (int i = 0; i < 7; i++) {
            if (notes[i] < notes[i + 1]) {
                descending = false;
                break;
            }
        }

        // 결과 설정
        if (ascending) {
            result = "ascending";
        } else if (descending) {
            result = "descending";
        }

        // 결과 출력
        System.out.println(result);

        scanner.close();
    }
}