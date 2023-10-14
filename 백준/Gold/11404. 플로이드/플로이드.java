import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	
    	int[][] map = new int[n+1][n+1];
    	for(int i=1; i<=n; i++) {
    		for(int j=1; j<=n; j++) {
    			if(i!=j)
    				map[i][j] = Integer.MAX_VALUE/2;
    		}
    	}
    	
    	for(int i=0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		map[a][b] = c < map[a][b] ? c : map[a][b];
    	}
    	
    	for(int k=1; k<=n; k++) {
    		for(int i=1; i<=n; i++) {
    			for(int j=1; j<=n; j++) {
    				map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
    			}
    		}
    	}
    	
    	for(int i=1; i<=n; i++) {
    		for(int j=1; j<=n; j++) {
    			if(map[i][j] == Integer.MAX_VALUE/2)
    				System.out.print("0 ");
    			else
    				System.out.print(map[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}