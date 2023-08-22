import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, companyX, companyY, homeX, homeY, answer;
	static node map[];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 BufferedReader 선언
		StringTokenizer st;
			
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new node[N];
			visited = new boolean[N];
			st = new StringTokenizer(br.readLine());
			
			companyX = Integer.parseInt(st.nextToken());
			companyY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			for(int i=0; i<N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[i] = new node(x, y);
			}
			
			dfs(0, companyX, companyY, homeX, homeY, 0);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int depth, int cX, int cY, int hX, int hY, int cnt) {
		if(depth==N) {
			cnt += Math.abs(cX-hX) + Math.abs(cY-hY);
			if(answer>cnt)
				answer=cnt;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				int d = Math.abs(map[i].x-cX) + Math.abs(map[i].y-cY);
				dfs(depth+1, map[i].x, map[i].y, hX, hY, cnt+d);
				visited[i] = false;
			}
		}
	}
	
	static class node {
		int x, y;

		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}