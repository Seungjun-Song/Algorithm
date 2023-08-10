import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, K, cnt=0, step=0;
	static int arr[], robot[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N*2];
		robot = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N*2; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		func();
		System.out.println(step);
	}
	
	static void func() {
		step++;
		cnt = 0;
		
		// 1. 벨트 및 로봇 회전
		int temp = arr[arr.length-1];
		for(int i=arr.length-1; i>0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
		
		for(int i=N-1; i>0; i--) {
			robot[i] = robot[i-1];
		}
		robot[0] = 0;
		
		if(robot[N-1]>0) {
			robot[N-1]=0;
		}
		
		// 2. 로봇 이동
		for(int i=N-2; i>-1; i--) {
			if(robot[i]==1 && robot[i+1]==0 && arr[i+1]>0) {
				robot[i]=0;
				robot[i+1]=1;
				arr[i+1]--;
			}
		}
		if(robot[N-1]>0) {
			robot[N-1]=0;
		}
		
		// 3. 로봇 올리기
		if(arr[0]>0) {
			arr[0]--;
			robot[0]=1;
		}
		
		// 4. 내구도 체크
		if(check()>=K) return;
		else func();
	}
	
	static int check() { // 벨트 내구도 체크(0인 경우 false 반환)
		for(int i=0; i<N*2; i++) {
			if(arr[i]==0) cnt++;
		}
		return cnt;
	}
}