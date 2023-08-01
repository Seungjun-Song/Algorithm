import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int ladder[][];
	static boolean visited[][];
	static int answer = 0;
	static int dx[] = {0, 0, -1};
	static int dy[] = {1, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			br.readLine();
			ladder = new int[101][101];
			visited = new boolean[101][101];
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<100; i++) {
				if(ladder[99][i] == 2) {
					dfs(98, i);
					break;
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}	
	
	static void dfs(int x, int y) {
		if(x == 0) {
			answer = y;
			return;
		}
		
		for(int i=0; i<3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<=99 && 0<=ny && ny<=99 
					&& ladder[nx][ny]==1 && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny);
				return;
			}
		}
	}
}