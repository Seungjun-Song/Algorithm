import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int alpha[];

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        alpha = new int[26];
        
        for(int i=0; i<N; i++) {
        	String s = br.readLine();
        	for(int j=0; j<s.length(); j++) {
        		alpha[s.charAt(j)-'A'] += Math.pow(10, s.length()-j-1);
        	}
        }
        
        Arrays.sort(alpha);
        int cnt = 9, sum = 0;
        for(int i=25; i>-1; i--) {
        	if(alpha[i] != 0) sum += alpha[i]*cnt--; 
        }
        
        System.out.println(sum);
    }
}