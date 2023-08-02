import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] num = new int[3];
	static int[] card;
	static int sum = 0;
	static int answer = 0;

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		card = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0);
		System.out.println(answer);
    }
	
	static void comb(int x, int y) {
		if(y == 3) {
			for(int i=0; i<3; i++) sum += num[i];

			if(Math.abs(sum-M) < Math.abs(answer-M)
					&& sum<=M) {

				answer = sum;
			}
			sum = 0;
			return;
		}
		
		if(x == N) return;
		num[y] = card[x];
		comb(x+1, y+1);
		comb(x+1, y);
	}
}
