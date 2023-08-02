import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	int stock[] = new int[N];
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<N; i++) {
        		stock[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	// 뒤에서부터 앞으로 오면서 높은 숫자가 오면 최대값 변경
        	int maxValue = 0;
        	long sum = 0;
        	for(int i=N-1; i>-1; i--) {
        		if(maxValue < stock[i]) {
        			maxValue = stock[i];
        		} else {
        			sum += maxValue - stock[i];
        		}
        	}
        	System.out.println(sum);
        }
    }    
}