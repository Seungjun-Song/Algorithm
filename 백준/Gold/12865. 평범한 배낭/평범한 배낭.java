import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] memoi;
	static int[][] item;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		memoi = new int[K+1];
		item = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			item[i][0] = W;
			item[i][1] = V;
		}
		
		for(int i=1; i<=N; i++) {
			// 가장 큰 무게부터 작은 무게로 움직이면서
			for(int w=K; w>=item[i][0]; w--) {
				// memoi[w] => i번째 item 을 고려하기 전까지 w 무게를 만드는데 최상의 value
				// memoi[w] 를 새로운 현재 고려하는 값으로 덮어쓰지 않으면 이전 item을 고려한 최상의 value
				memoi[w] = Math.max(memoi[w], memoi[w-item[i][0]] + item[i][1]);
			}
		}
		
		System.out.println(memoi[K]);
	}

}