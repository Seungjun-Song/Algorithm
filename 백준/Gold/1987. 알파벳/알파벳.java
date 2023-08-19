import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, answer=0;
	static char alphabet[][];
	static boolean alpha[] = new boolean[26];
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabet = new char[R][C];
		for(int i=0; i<R; i++) {
			alphabet[i] = br.readLine().toCharArray();
		}
		
		dfs(0, 0, 1);
		System.out.println(answer);
	}
	
	static void dfs(int x, int y, int cnt) {
		answer = Math.max(answer, cnt);
		alpha[alphabet[x][y]-65] = true;
		
		int nx, ny;
		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(0>nx || nx>=R || 0>ny || ny>=C) continue;
			
			if(!alpha[alphabet[nx][ny]-65]) {
				alpha[alphabet[nx][ny]-65] = true;
				dfs(nx, ny, cnt+1);
				alpha[alphabet[nx][ny]-65] = false;
			}
		}
	}
}