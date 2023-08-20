import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, number=1, answer=Integer.MAX_VALUE;
	static int map[][];
	static boolean visited[][];
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	
	public static void main(String args[]) throws IOException{
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
        
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(map[i][j]==1 && !visited[i][j]) {
        			numbering(i, j);
        			number+=1;
        		}
        	}
        }
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(map[i][j]!=0) {
        			visited = new boolean[N][N];
        			bfs(i, j, map[i][j], 0);
        		}
        	}
        }
        
        System.out.println(answer);
    }
	
	static void numbering(int x, int y) {
		Deque<node> q = new ArrayDeque<>();
		q.offer(new node(x, y));
		visited[x][y] = true;
		map[x][y] = number;
		while(!q.isEmpty()) {
			node no = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = no.x + dx[i];
				int ny = no.y + dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<N
						&& !visited[nx][ny] && map[nx][ny]==1) {
					visited[nx][ny] = true;
					map[nx][ny] = number;
					q.offer(new node(nx, ny));
				}
			}
		}
	}
	
	static void bfs(int x, int y, int num, int cnt) {
		Deque<node> q = new ArrayDeque<>();
		q.offer(new node(x, y, cnt));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			node no = q.poll();
			if(answer>no.cnt-1 && map[no.x][no.y]!=num
					&& map[no.x][no.y]!=0) {
				answer=no.cnt-1;
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int nx = no.x + dx[i];
				int ny = no.y + dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<N
						&&!visited[nx][ny] && map[nx][ny]!=num) {
					visited[nx][ny] = true;
					q.offer(new node(nx, ny, no.cnt+1));
				}
			}
		}
	}
	
	static class node {
		int x, y, cnt;

		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

}