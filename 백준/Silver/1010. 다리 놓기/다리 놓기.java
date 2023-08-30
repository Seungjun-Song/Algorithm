import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간초과
public class Main {
	
	static int T, N, M;
	static int[][] memoi;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			memoi = new int[M+1][N+1]; // M*M X
			
			System.out.println(comb(M, N));
		}
	}
	
	static int comb(int srcIdx, int tgtIdx) {
		if(srcIdx==tgtIdx || tgtIdx==0) {
			return memoi[srcIdx][tgtIdx] = 1;
		}
		
		if(memoi[srcIdx][tgtIdx] > 0) return memoi[srcIdx][tgtIdx];
		
		return memoi[srcIdx][tgtIdx] = comb(srcIdx-1, tgtIdx-1) + comb(srcIdx-1, tgtIdx);
	}

}