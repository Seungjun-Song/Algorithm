import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int big[][] = new int[N][2];
		int answer[] = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			big[i][0] = Integer.parseInt(st.nextToken());
			big[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(big[i][0] < big[j][0] && big[i][1] < big[j][1])
					answer[i]++;
			}
		}
		
		for(int a : answer) {
			System.out.print(a+1 + " ");
		}
		
	}
}