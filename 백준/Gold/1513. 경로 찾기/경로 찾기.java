import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, C;
	static int map[][], dp[][][][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		dp = new int[51][51][51][51];
		dp[1][1][0][0] = 1;
		for(int i=1; i<=C; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			map[A][B] = i;
			if(A==1 && B==1) {
				dp[1][1][0][0] = 0;
				dp[1][1][i][1] = 1;
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(i==1 && j==1) continue;
				if(map[i][j]>0) { // 다음에 갈 곳이 0이 아닐 때
					for(int l=0; l<map[i][j]; l++) {
						for(int k=0; k<=l; k++) {
							dp[i][j][map[i][j]][k+1] += dp[i-1][j][l][k] + dp[i][j-1][l][k];
							dp[i][j][map[i][j]][k+1] %= 1000007;
						}
					}
				} else { // 다음에 갈 곳이 0일 때
					for(int l=0; l<=C; l++) {
						for(int k=0; k<=l; k++) {
							dp[i][j][l][k] = dp[i-1][j][l][k] + dp[i][j-1][l][k];
							dp[i][j][l][k] %= 1000007;
						}
					}
				}
				
			}
		}
		
		for(int i=0; i<=C; i++) {
			int sum = 0;
			for(int j=0; j<=C; j++) {
				sum += dp[N][M][j][i];
			}
			sum %= 1000007;
			System.out.print(sum + " ");
		}
	}

}