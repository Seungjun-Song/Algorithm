import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, minValue;
	static int map[][], dp[][];
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = s.charAt(j) - '0'; // 1이 흰 방, 0이 검은 방
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs(0, 0);
		System.out.println(dp[n-1][n-1]);
	}
	
	static void bfs(int x, int y) {
		Queue<node> q = new LinkedList<>();
		q.offer(new node(x, y));
		dp[0][0] = 0;
		while(!q.isEmpty()) {
			node no = q.poll();
			for(int i=0; i<4; i++) {
				int nx = no.x + dx[i];
				int ny = no.y + dy[i];
				
				if(0>nx || 0>ny || n<=nx || n<=ny || dp[nx][ny]<=dp[no.x][no.y]) continue;
				
				if(map[nx][ny]==1) { // 1이 흰 방(갈 수 있는 방)
					dp[nx][ny] = dp[no.x][no.y];
					q.offer(new node(nx, ny));
				} else { // 0이 검은 방(갈 수 없는 방)
					dp[nx][ny] = dp[no.x][no.y] + 1;
					q.offer(new node(nx, ny));
				}
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