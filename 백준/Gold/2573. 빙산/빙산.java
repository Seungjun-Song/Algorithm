import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, year=0;
	static int arr[][], temp[][];
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
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		temp = new int[N][M];
		copy(temp, arr);
		
		visited = new boolean[N][M];
		while(check()) { // 빙산 두덩이 확인
			visited = new boolean[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j]>0)
						melt(i, j); // 빙산 녹이기
				}
			}
			copy(arr, temp);
			year++;
		}
		System.out.println(year);
    }
	
	static void copy(int a[][], int b[][]) {
		for(int i=0; i<N; i++) {
			a[i] = b[i].clone();
		}
	}
	
	static void melt(int x, int y) {
		int nx, ny, cnt=0;
		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(0<=nx && nx<N && 0<=ny && ny<M && arr[nx][ny]==0)
				cnt++;
		}
		
		temp[x][y] = arr[x][y] - cnt;
		temp[x][y] = temp[x][y]<0 ? 0 : temp[x][y];
	}
	
	static boolean check() {
		int zero=0, cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]>0 && !visited[i][j]) {
					visited[i][j] = true;
					dfs(i, j);
					cnt++;
				}
				if(arr[i][j]==0) zero++;
			}
		}
		if(zero==N*M && cnt==0) year=0;
		if(cnt==1) return true;
		else return false;
	}
	
	static void dfs(int x, int y) {
		int nx, ny;
		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(0<=nx && nx<N && 0<=ny && ny<M && arr[nx][ny]>0 && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}
}