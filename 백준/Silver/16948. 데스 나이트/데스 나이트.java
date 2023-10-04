import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, answer;
	static int r1, c1, r2, c2;
	static int[] dx = {-2, -2, 0, 0, 2, 2};
	static int[] dy = {-1, 1, -2, 2, -1, 1};
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		visited = new boolean[N][N];
		visited[r1][c1] = true;
		answer = Integer.MAX_VALUE;
		
		bfs(r1, c1);
		System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
	}
	
	static void bfs(int x, int y) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(x, y, 0));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			node no = q.poll();
			
			if(no.x==r2 && no.y==c2) {
				answer = Math.min(answer, no.cnt);
				break;
			}
			
			for(int i=0; i<6; i++) {
				int nx = no.x + dx[i];
				int ny = no.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				q.add(new node(nx, ny, no.cnt+1));
			}
		}
	}
	
	static class node {
		int x, y, cnt;

		public node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}