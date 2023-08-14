import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int arr[][];
	static boolean visited[][];
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
        	String s = br.readLine();
        	for(int j=0; j<M; j++) {
        		arr[i][j] = (int) s.charAt(j) - 48;
        	}
        }
        bfs(0, 0);
        System.out.println(arr[N-1][M-1]);
    }
	
	static void bfs(int x, int y) {
		Deque<node> queue = new ArrayDeque<>();
		queue.add(new node(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			node q = queue.poll();
			int nx, ny;
			for(int i=0; i<4; i++) {
				nx = q.x + dx[i];
				ny = q.y + dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M && arr[nx][ny]==1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new node(nx, ny));
					arr[nx][ny] = arr[q.x][q.y] + 1;
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