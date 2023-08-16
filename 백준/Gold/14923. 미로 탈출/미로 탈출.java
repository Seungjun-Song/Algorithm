import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, Hx, Hy, Ex, Ey;
	static int[][] arr;
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
		
		arr = new int[N+1][M+1];
		visited = new boolean[N+1][M+1][2];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(Hx, Hy, Ex, Ey);
	}

	static void bfs(int x, int y, int endX, int endY) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(x, y, 1, 0));
		visited[x][y][1] = true;
		int answer = -1;
		
		while(!q.isEmpty()) {
			node no = q.poll();
			int curX = no.x;
			int curY = no.y;
			int cnt = no.cnt;
			if(curX==endX && curY==endY) {
				answer = no.ans;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if(1>nx || nx>N || 1>ny || ny>M) continue;
				if(cnt>0 && !visited[nx][ny][cnt-1] && arr[nx][ny]==1) {
					visited[nx][ny][cnt-1] = true;
					q.add(new node(nx, ny, cnt-1, no.ans+1));
				}
				if(!visited[nx][ny][cnt] && arr[nx][ny] == 0) {
					visited[nx][ny][cnt] = true;
					q.add(new node(nx, ny, cnt, no.ans+1));
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