import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] memoi;
	static int[][] item;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		memoi = new int[N+1][K+1];
		item = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			item[i][0] = W;
			item[i][1] = V;
		}
		
		for(int i=1; i<=N; i++) {
			for(int w=1; w<=K; w++) {
				
				if(item[i][0]<=w) {
					// 선택 O
					int sel_o = memoi[i-1][w-item[i][0]] + item[i][1];
					
					// 선택 X
					int sel_x = memoi[i-1][w];
					
					memoi[i][w] = Math.max(sel_o, sel_x);
				} else {
					memoi[i][w] = memoi[i-1][w];
				}
			}
		}
		
		System.out.println(memoi[N][K]);
	}

}