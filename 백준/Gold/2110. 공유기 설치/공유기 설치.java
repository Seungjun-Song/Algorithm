
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int left = 1; // 최소 1
		int right = arr[N-1] - arr[0]; // 최대 첫 집과 마지막 집 거리
		int answer = 0;
		while(left<=right) {
			int mid = (left+right) / 2;
			
			int cnt = 1;
			int start = arr[0];
			
			for(int i=1; i<N; i++) {
				if(arr[i]-start >= mid) {
					cnt++; // 공유기 설치
					start = arr[i]; // 집 위치 갱신
				}
			}
			
			if (cnt >= C) { // 공유기를 더 설치할 수 있는 경우
                answer = mid;
                left = mid + 1;
            } else { // 공유기를 더 설치할 수 없는 경우
                right = mid - 1;
            }
		}
		System.out.println(answer);
	}
}
