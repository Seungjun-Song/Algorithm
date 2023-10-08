import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int money[] = new int[N];
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}

		int left = 0;
		int right = 100000 * 10000;
		int answer = 0;
		while (left <= right) {
			int mid = (left + right) / 2;

			int cnt = 1;
			int sum = 0;

			for (int i = 0; i < N; i++) {
				if (money[i] > mid) {
					cnt = M + 1;
					break;
				}
				if (sum + money[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum += money[i];
			}

			if (cnt <= M) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			
		}
		System.out.println(answer);
	}
}