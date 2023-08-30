import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, minValue=Integer.MAX_VALUE;
	static int map[][];
	static int src[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	static int tgt[];
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		tgt = new int[N];
		visited = new boolean[N];
		
		perm(0);
		System.out.println(minValue);
	}
	
	static void perm(int tgtIdx) {
		if(tgtIdx==N) {
			int sum = 0;
			
			for(int i=0; i<N-1; i++) {
				if(map[tgt[i]][tgt[i+1]]==0) return;
				sum += map[tgt[i]][tgt[i+1]];
			}
			
			if(map[tgt[N-1]][tgt[0]]==0) return;
			sum += map[tgt[N-1]][tgt[0]];
			minValue = Math.min(minValue, sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				tgt[tgtIdx] = src[i];
				perm(tgtIdx+1);
				visited[i] = false;
			}
		}
	}

}