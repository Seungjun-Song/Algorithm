import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, Hx, Hy, Ex, Ey, answer=-1;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Hx = Integer.parseInt(st.nextToken());
		Hy = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Ex = Integer.parseInt(st.nextToken());
		Ey = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1][2];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(Hx, Hy, Ex, Ey);
	}
	
	static void bfs(int x, int y, int endX, int endY) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(x, y, 1, 0));
		visited[x][y][1] = true;
		while(!q.isEmpty()) {
			node no = q.poll();
			
			if(no.x==endX && no.y==endY) {
				answer = no.ans;
				break;
			}
			
			int nx, ny;
			for(int i=0; i<4; i++) {
				nx = no.x + dx[i];
				ny = no.y + dy[i];
				
				if(1>nx || nx>N || 1>ny || ny>M) continue;
				
				if(no.cnt>0 && !visited[nx][ny][no.cnt-1] && map[nx][ny]==1) {
					visited[nx][ny][no.cnt-1] = true;
					q.add(new node(nx, ny, no.cnt-1, no.ans+1));
				}
				
				if(!visited[nx][ny][no.cnt] && map[nx][ny]==0) {
					visited[nx][ny][no.cnt] = true;
					q.add(new node(nx, ny, no.cnt, no.ans+1));
				}
			}
		}
		System.out.println(answer);
	}
	
	static class node {
		int x, y, cnt, ans;

		public node(int x, int y, int cnt, int ans) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.ans = ans;
		}
	}
}