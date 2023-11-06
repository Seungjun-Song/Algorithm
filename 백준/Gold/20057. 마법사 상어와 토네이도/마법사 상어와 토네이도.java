import java.util.*;
import java.io.*;

public class Main {
	
	static int N, answer = 0;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int[][] sdx = {{-1, 1, -2, 2, 0, -1, 1, -1, 1}, {-1, -1, 0, 0, 2, 0, 0, 1, 1}, {-1, 1, -2, 2, 0, -1, 1, -1, 1}, {1, 1, 0, 0, -2, 0, 0, -1, -1}};
	static int[][] sdy = {{1, 1, 0, 0, -2, 0, 0, -1, -1}, {-1, 1, -2, 2, 0, -1, 1, -1, 1}, {-1, -1, 0, 0, 2, 0, 0, 1, 1}, {-1, 1, -2, 2, 0, -1, 1, -1, 1}};
	static int[] rate = {1, 1, 2, 2, 5, 7, 7, 10, 10};
	
	public static void main(String[] args) throws Exception {
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
		
		tornado(N/2, N/2);
		System.out.println(answer);
	}
	
	static void tornado(int x, int y) {
		int distance = 1;
		int dir = 0;
		while(true) {
			for(int d=0; d<distance; d++) {
				if(x==0 && y==0) break;
				x += dx[dir];
				y += dy[dir];
				int sand = map[x][y];
				int a = sand;
				for(int i=0; i<9; i++) {
					int nx = x + sdx[dir][i];
					int ny = y + sdy[dir][i];
					if(nx<0 || ny<0 || nx>N-1 || ny>N-1) {
						answer += (int) (sand * (rate[i] * 0.01));
						a -= (int) (sand * (rate[i] * 0.01));
						continue;
					}
					map[nx][ny] += (int) (sand * (rate[i] * 0.01));
					a -= (int) (sand * (rate[i] * 0.01));
				}
				map[x][y] = 0;
				if(x+dx[dir]<0 || y+dy[dir]<0 || x+dx[dir]>N-1 || y+dy[dir]>N-1)
					answer += a;
				else
					map[x+dx[dir]][y+dy[dir]] += a;
			}
			if(x==0 && y==0) break;
			dir++;
			for(int d=0; d<distance; d++) {
				x += dx[dir];
				y += dy[dir];
				int sand = map[x][y];
				int a = sand;
				for(int i=0; i<9; i++) {
					int nx = x + sdx[dir][i];
					int ny = y + sdy[dir][i];
					if(nx<0 || ny<0 || nx>N-1 || ny>N-1) {
						answer += (int) (sand * (rate[i] * 0.01));
						a -= (int) (sand * (rate[i] * 0.01));
						continue;
					}
					map[nx][ny] += (int) (sand * (rate[i] * 0.01));
					a -= (int) (sand * (rate[i] * 0.01));
				}
				map[x][y] = 0;
				if(x+dx[dir]<0 || y+dy[dir]<0 || x+dx[dir]>N-1 || y+dy[dir]>N-1)
					answer += a;
				else
					map[x+dx[dir]][y+dy[dir]] += a;
			}
			
			dir = dir+1 > 3 ? 0 : dir+1;
			distance++;
		}
	}
}