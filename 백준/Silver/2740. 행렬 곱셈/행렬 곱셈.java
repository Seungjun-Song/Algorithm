import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int arr1[][];
	static int arr2[][];
	static int answer[][];

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr1 = new int[N][M];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		arr1[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr2 = new int[M][K];
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<K; j++) {
        		arr2[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        answer = new int[N][K];
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		for(int k=0; k<K; k++) {
        			answer[i][k] += arr1[i][j] * arr2[j][k]; 
        		}
        	}
        }
        
        for(int[] a : answer) {
        	for(int b : a) {
        		sb.append(b + " ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
}