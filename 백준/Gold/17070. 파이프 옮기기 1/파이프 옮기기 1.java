import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] input;
    static int[][][] dp;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        input = new int[N+1][N+1];
        dp = new int[3][N+1][N+1]; 
        
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[0][1][2] = 1;
        
        for(int i=1; i<=N; i++) {
            for(int j=2; j<=N; j++) {
                //가로로 이동하는 dp
                if(j<N && input[i][j+1]==0)
                    dp[0][i][j+1] = dp[0][i][j] + dp[2][i][j];

                //세로로 이동하는 dp
                if(i<N && input[i+1][j]==0)
                    dp[1][i+1][j] = dp[1][i][j] + dp[2][i][j];
                
                //대각선으로 이동하는 dp
                if(i<N && j<N && input[i+1][j+1]==0 && input[i+1][j]==0 && input[i][j+1]==0)
                    dp[2][i+1][j+1] = dp[0][i][j] + dp[1][i][j] + dp[2][i][j];
            }
        }
        
        System.out.println(dp[0][N][N] + dp[1][N][N] + dp[2][N][N]);

    }

}