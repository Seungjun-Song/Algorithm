import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, x1, x2, y1, y2, sum;
	static int arr[][];

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=M; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
        	sb = new StringBuilder();
        	sum = 0;
        	st = new StringTokenizer(br.readLine());
        	x1 = Integer.parseInt(st.nextToken());
        	y1 = Integer.parseInt(st.nextToken());
        	x2 = Integer.parseInt(st.nextToken());
        	y2 = Integer.parseInt(st.nextToken());
        	
        	for(int j=x1; j<=x2; j++) {
        		for(int k=y1; k<=y2; k++) {
        			sum += arr[j][k];
        		}
        	}
        	
        	sb.append(sum);
        	System.out.println(sb);
        }
    }
}