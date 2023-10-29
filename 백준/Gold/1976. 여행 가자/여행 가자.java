import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	int M = Integer.parseInt(br.readLine());
    	int[][] map = new int[N+1][N+1];
    	
    	for(int i=1; i<=N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=1; j<=N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			
    			if(i==j)
    				map[i][j] = 1;
    		}
    	}
    	
    	for(int k=1; k<=N; k++) {
    		for(int i=1; i<=N ;i++) {
    			for(int j=1; j<=N; j++) {
    				if(map[i][k]==1 && map[k][j]==1)
    					map[i][j] = 1;
    			}
    		}
    	}
    	
    	boolean flag = true;
    	st = new StringTokenizer(br.readLine());
    	int S = Integer.parseInt(st.nextToken());
    	for(int i=0; i<M-1; i++) {
    		int X = Integer.parseInt(st.nextToken());
    		
    		if(map[S][X]==0)
    			flag = false;
    	}
    	
    	if(flag)
    		System.out.println("YES");
    	else
    		System.out.println("NO");
    }
}