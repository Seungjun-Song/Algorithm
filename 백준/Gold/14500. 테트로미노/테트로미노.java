import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int arr[][];
	static boolean visited[][];
	static int answer = 0;
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
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) { 
			for(int j=0; j<M; j++) {
				visited[i][j] = true;
				dfs(1, i, j, arr[i][j]);
				visited[i][j] = false;
			}
		}
		
		System.out.println(answer);
    }
	
	static void dfs(int depth, int x, int y, int sum) {
		if(depth == 4) {
			answer = Math.max(answer, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny]) {
				if(depth==2) {
					visited[nx][ny] = true;
					dfs(depth+1, x, y, sum+arr[nx][ny]);
					visited[nx][ny] = false;
				}
				
				visited[nx][ny] = true;
				dfs(depth+1, nx, ny, sum+arr[nx][ny]);
				visited[nx][ny] = false;
			}
		}
	}

}