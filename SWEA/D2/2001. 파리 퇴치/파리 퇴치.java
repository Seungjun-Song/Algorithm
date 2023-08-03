import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M, answer, sum;
	static int arr[][];

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	arr = new int[N][N];
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<N; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	answer = 0;
        	for(int i=0; i<N-M+1; i++) {
        		for(int j=0; j<N-M+1; j++) {
        			sum = 0;
        			func(i, j);
        		}
        	}
        	
        	System.out.println("#" + tc + " " + answer);
        }
    }
	
	static void func(int x, int y) {
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				sum += arr[x+i][y+j];
			}
		}
		if(answer < sum) answer = sum;
	}
}