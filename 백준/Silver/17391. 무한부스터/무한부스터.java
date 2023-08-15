import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int map[][], cnt[][];
	static int dx[] = {0, 1};
	static int dy[] = {1, 0};

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cnt = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				cnt[i][j] = Integer.MAX_VALUE;
			}
		}
		
		cnt[0][0] = 0;
		bfs(0, 0);
		System.out.println(cnt[N-1][M-1]);
	}
	
	static void bfs(int x, int y) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(x, y));
		int nx, ny, booster;
		while(!q.isEmpty()) {
			node no = q.poll();
			booster = map[no.x][no.y];
			
			if(no.x==N-1 && no.y==M-1) return;
			
			for(int i=0; i<2; i++) { // 오른쪽, 아래쪽
				nx = no.x;
				ny = no.y;
				for(int j=1; j<=booster; j++) {
					nx = nx + dx[i];
					ny = ny + dy[i];
					
					if(0<=nx && nx<N && 0<=ny && ny<M && cnt[nx][ny]>cnt[no.x][no.y]+1) {
						cnt[nx][ny] = cnt[no.x][no.y]+1;
						q.add(new node(nx, ny));
					}
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