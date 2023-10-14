import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;

    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    map = new int[N][N];
	    for(int i=0; i<N; i++) {
	    	Arrays.fill(map[i], Integer.MAX_VALUE/2);
	    }
	    
	    for(int i=0; i<N; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j=0; j<N; j++) {
	    		int x = Integer.parseInt(st.nextToken());
	    		if(x==1)
	    			map[i][j] = x;
	    	}
	    }
	    
	    for(int k=0; k<N; k++) {
	    	for(int i=0; i<N; i++) {
	    		for(int j=0; j<N; j++) {
	    			map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]); 
	    		}
	    	}
	    }
	    
	    for(int i=0; i<N; i++) {
	    	for(int j=0; j<N; j++) {
	    		if(map[i][j]==Integer.MAX_VALUE/2)
	    			System.out.print("0 ");
	    		else
	    			System.out.print("1 ");
	    	}
	    	System.out.println();
	    }
    }
}