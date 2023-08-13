import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int arr[], sensor[];
	static List<Integer> distance = new ArrayList<>();;

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		arr = new int[N];
		sensor = new int[N];
		
		if(N<=K) {
			System.out.println(0);
		} else {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 역순 정렬
			Arrays.sort(arr);
			for(int i=0; i<N; i++) {
				sensor[i] = arr[arr.length-i-1];
			}
			
			// 거리 계산
			for(int i=0; i<N-1; i++) {
				distance.add(sensor[i] - sensor[i+1]);
			}
			
			// 거리 최댓값 제거
			for(int i=0; i<K-1; i++) {
				distance.remove(Collections.max(distance));
			}
			
			int sum = 0;
			for(int i : distance) {
				sum += i;
			}
			System.out.println(sum);
		}
    }
}