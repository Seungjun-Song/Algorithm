import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, answer=0;
	static int map[][];
	static int dx[] = {0, 1, 1};
	static int dy[] = {1, 0, 1};
	
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        dfs(1, 2, 0);
        System.out.println(answer);
    }
	
	static void dfs(int x, int y, int direction) {
		if(x==N && y==N) {
			answer++;
			return;
		}
		
		node no;
		if(direction==0) { // 가로
			no = H(x, y);
			if(no!=null)
				dfs(no.x, no.y, no.d);
			no = D(x, y);
			if(no!=null)
				dfs(no.x, no.y, no.d);
		} else if(direction==1) { // 세로
			no = V(x, y);
			if(no!=null)
				dfs(no.x, no.y, no.d);
			no = D(x, y);
			if(no!=null)
				dfs(no.x, no.y, no.d);
		} else { // 대각선
			no = H(x, y);
			if(no!=null)
				dfs(no.x, no.y, no.d);
			no = V(x, y);
			if(no!=null)
				dfs(no.x, no.y, no.d);
			no = D(x, y);
			if(no!=null)
				dfs(no.x, no.y, no.d);
		}
	}
	
	static node H(int x, int y) { // 가로 이동
		int nx = x;
		int ny = y+1;
		
		if(1<=nx && nx<=N && 1<=ny && ny<=N && map[nx][ny]==0) {
			return new node(nx, ny, 0);
		}
		return null;
	}
	
	static node V(int x, int y) { // 세로 이동
		int nx = x+1;
		int ny = y;
		
		if(1<=nx && nx<=N && 1<=ny && ny<=N && map[nx][ny]==0) {
			return new node(nx, ny, 1);
		}
		return null;
	}
	
	static node D(int x, int y) { // 대각선 이동
		int nx = x+1;
		int ny = y+1;
		
		if(1<=nx && nx<=N && 1<=ny && ny<=N
				&& map[nx][ny]==0 && map[nx-1][ny]==0 && map[nx][ny-1]==0) {
			return new node(nx, ny, 2);
		}
		return null;
	}
	
	static class node {
		int x, y, d;

		public node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}