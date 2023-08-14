import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char arr[][];
	static boolean visited[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new char[N][];
        
        for(int i=0; i<N; i++) {
        	String s = br.readLine();
        	arr[i] = s.toCharArray();
        }
        
        divide(0, 0, N);
        System.out.println(sb);
    }
	
	static boolean check(int y, int x, int n) {
		char ch = arr[y][x];
		for(int i=y; i<y+n; i++) {
			for(int j=x; j<x+n; j++) {
				if(arr[i][j]!=ch)
					return false;
			}
		}
		sb.append(ch);
		return true;
	}
	
	static void divide(int y, int x, int n) {
		if( !check(y, x, n) ) {
			int half = n / 2;
			sb.append("(");
			divide(y, x, half);
			divide(y, x+half, half);
			divide(y+half, x, half);
			divide(y+half, x+half, half);
			sb.append(")");
		}
	}
	
}