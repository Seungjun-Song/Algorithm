import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, start, link, min;
	static int arr[][];	
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			func(0, 0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	static void func(int depth, int idx) {
		if(depth==N/2) {
			func2();
			return;
		}
		
		for(int i=idx; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				func(depth+1, i+1);
				visited[i] = false;				
			}
		}
	}
	
	static void func2() {
		start = 0; link = 0;
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(visited[i] && visited[j])
					start += arr[i][j] + arr[j][i];
				else if(!visited[i] && !visited[j])
					link += arr[i][j] + arr[j][i]; 
			}
		}
		
		min = Math.abs(start-link)<min ? Math.abs(start-link) : min;
	}
}