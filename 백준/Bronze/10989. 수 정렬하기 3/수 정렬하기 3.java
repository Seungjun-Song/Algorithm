import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 처리하기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 빠르게 처리하기 위한 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 줄에서 수의 개수 N을 입력 받음
        int N = Integer.parseInt(br.readLine());

        // 카운팅 정렬을 위한 배열 선언 (수의 범위가 1 ~ 10000 이므로 크기는 10001)
        int[] count = new int[10001];

        // N개의 수를 입력받아 카운트 배열에 저장
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            count[number]++;
        }

        // 정렬된 결과를 출력
        for (int i = 1; i < count.length; i++) {
            while (count[i] > 0) {
                bw.write(i + "\n");
                count[i]--;
            }
        }

        // 스트림을 닫음
        br.close();
        bw.flush();
        bw.close();
    }
}