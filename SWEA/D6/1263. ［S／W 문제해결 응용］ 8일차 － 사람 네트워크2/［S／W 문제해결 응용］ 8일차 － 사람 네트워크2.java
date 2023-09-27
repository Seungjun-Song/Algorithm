import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String[] ss = br.readLine().split(" ");
			N = Integer.parseInt(ss[0]);
			
			arr = new int[N][N];
			for(int i=1; i<ss.length; i+=N) {
				for(int j=0; j<N; j++) {
					if(i/N==j) continue;
					if(ss[i+j].charAt(0) - '0' == 0)
						arr[(i-1)/N][j] = Integer.MAX_VALUE/2;
					else
						arr[(i-1)/N][j] = ss[i+j].charAt(0) - '0';
				}
			}
			
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
					}
				}
			}
			
			int answer = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				int sum = 0;
				for(int j=0; j<N; j++) {
					sum += arr[i][j];
				}
				answer = Math.min(answer, sum);
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
