import java.util.*;
import java.io.*;

public class Main {
	
	static int N, H, minValue, obstacleCnt;
	static int down[], up[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		down = new int[N/2];
		up = new int[N/2];
		for(int i=0; i<N/2; i++) {
			down[i] = Integer.parseInt(br.readLine());
			up[i] = Integer.parseInt(br.readLine());
			
		}
		Arrays.sort(down);
		Arrays.sort(up);
		
		minValue = Integer.MAX_VALUE;
		obstacleCnt = 0;
		for(int i=1; i<=H; i++) {
			int cnt = binarySearch(0, N/2, i, down) 
					+ binarySearch(0, N/2, H-i+1, up);
			if(minValue == cnt) {
				obstacleCnt++;
			} else if(minValue > cnt) {
				minValue = cnt;
				obstacleCnt = 1;
			}
		}
		System.out.println(minValue + " " + obstacleCnt);
	}
	
	static int binarySearch(int left, int right, int h, int[] arr) {
		while(left<right) {
			int mid = (left+right) / 2;
			
			if(arr[mid] >= h) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		return N/2 - left;
	}
}