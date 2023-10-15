import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	int[][] map = new int[N+1][N+1];
    	for(int i=1; i<=N; i++) {
    		for(int j=1; j<=N; j++) {
    			map[i][j] = Integer.MAX_VALUE/2;
    		}
    	}
    	
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		map[a][b] = c;
    	}
    	
    	for(int k=1; k<=N; k++) {
    		for(int i=1; i<=N; i++) {
    			for(int j=1; j<=N; j++) {
    				map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
    			}
    		}
    	}
    	
    	int ans = Integer.MAX_VALUE;
    	for(int i=1; i<=N; i++) {
    		for(int j=1; j<=N; j++) {
    			if(i==j
    					&& map[i][j]!=Integer.MAX_VALUE/2
    					&& ans>map[i][j])
    				ans = map[i][j];
    		}
    	}
    	System.out.println(ans!=Integer.MAX_VALUE ? ans : -1);
    }
}