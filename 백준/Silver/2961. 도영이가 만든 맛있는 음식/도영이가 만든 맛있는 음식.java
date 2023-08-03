import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static int S;
	static int B;
	static int sum = 0;
	static boolean visited[];
	static int minValue = Integer.MAX_VALUE;

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[N][2];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i][0] = Integer.parseInt(st.nextToken());
        	arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1; i<=N; i++) {
        	S = 1;
        	B = 0;
        	func(i, 0);
        }
        System.out.println(minValue);
    }
	
	static void func(int depth, int cnt) {
		if(depth == cnt) {
			if(minValue > Math.abs(S-B)) {
				minValue = Math.abs(S-B); 
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				S *= arr[i][0];
				B += arr[i][1];
				func(depth, cnt+1);
				S /= arr[i][0];
				B -= arr[i][1];
				visited[i] = false;
			}
		}
	}
	
}