import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int T, K, answer;
	static int arr[], sum[];
	static int dp[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			K = Integer.parseInt(br.readLine());
			
			arr = new int[K+1];
			sum = new int[K+1];
			dp = new int[K+1][K+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + arr[i];
			}
			
			for(int i=1; i<=K; i++) {
				for(int j=1; i+j<=K; j++) {
					int l = i+j;
					dp[j][l] = Integer.MAX_VALUE;
					for(int q=j; q<l; q++) {
						dp[j][l] = Math.min(dp[j][l], dp[j][q]+dp[q+1][l]
								+sum[l]-sum[j-1]);
					}
				}
			}
			
			System.out.println(dp[1][K]);
		}
	}
}