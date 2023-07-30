import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	private static String answer[]; 

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s;
		while((s = br.readLine()) != null) {
			int N = Integer.parseInt(s);
			N = (int) Math.pow(3, N);
			
			answer = new String[N];
			for(int i=0; i<N; i++) {
				answer[i] = " ";
			}
			
			dfs(N, 0, N-1);
			
			for(int i=0; i<answer.length; i++) {
				bw.write(answer[i]);
			}
			bw.flush();
			bw.newLine();
		}
		bw.close();

	}
	
	private static void dfs(int n, int start, int end) {
		if(n == 1) {
			answer[start] = "-";
		}
		else {
			dfs(n/3, start, start+n/3-1);
			dfs(n/3, end-n/3+1, end);
		}
		
	}

}