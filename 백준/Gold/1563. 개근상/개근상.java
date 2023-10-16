import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	int dp[][][] = new int[N+1][3][2];
    	dp[1][0][0] = 1; // O
    	dp[1][1][0] = 1; // A
    	dp[1][0][1] = 1; // L
    	
    	for(int i=2; i<=N; i++) {
    		dp[i][0][0] = (dp[i-1][0][0] + dp[i-1][1][0] + dp[i-1][2][0]) % 1000000;
    		dp[i][0][1] = (dp[i-1][0][0] + dp[i-1][1][0] + dp[i-1][2][0] +
    				dp[i-1][0][1] + dp[i-1][1][1] + dp[i-1][2][1]) % 1000000;
    		dp[i][1][0] = dp[i-1][0][0] % 1000000;
    		dp[i][1][1] = dp[i-1][0][1] % 1000000;
    		dp[i][2][0] = dp[i-1][1][0] % 1000000;
    		dp[i][2][1] = dp[i-1][1][1] % 1000000;
    	}
    	
    	int ans = (dp[N][0][0] + dp[N][0][1] + dp[N][1][0]
    			+ dp[N][1][1] + dp[N][2][0] + dp[N][2][1]) % 1000000;
    	System.out.println(ans);
    }
}