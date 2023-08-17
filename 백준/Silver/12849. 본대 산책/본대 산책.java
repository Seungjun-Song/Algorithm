import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
		
		int D = Integer.parseInt(br.readLine());
		long dp[] = new long[8];
		dp[0] = 1;
		// 0 정보과학관, 1 전산관, 2 미래관, 3 신양관, 4 한경직기념관, 5 진리관, 6 형남공학관, 7 학생회관
		for(int i=0; i<D; i++) {
			long temp[] = new long[8];
			temp[0] = dp[1] + dp[2];
			temp[1] = dp[0] + dp[2] + dp[3];
			temp[2] = dp[0] + dp[1] + dp[3] + dp[4];
			temp[3] = dp[1] + dp[2] + dp[4] + dp[5];
			temp[4] = dp[2] + dp[3] + dp[5] + dp[6];
			temp[5] = dp[3] + dp[4] + dp[7];
			temp[6] = dp[4] + dp[7];
			temp[7] = dp[5] + dp[6];
			
			for(int j=0; j<8; j++) 
				temp[j] = temp[j] % 1000000007;
			
			dp = temp.clone();
		}
		
		System.out.println(dp[0]);
	}
	
}