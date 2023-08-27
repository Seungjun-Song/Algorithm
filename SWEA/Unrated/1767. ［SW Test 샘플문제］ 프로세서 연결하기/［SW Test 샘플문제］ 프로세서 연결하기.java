import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N, maxCore, minWire;
	static int map[][];
	static List<node> coreList;
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			maxCore = Integer.MIN_VALUE;
			minWire = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			coreList = new ArrayList<>();
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num==1) {
						map[i][j] = num;
						
						if(i==0 || j==0 || i==N-1 || j==N-1) continue;
						coreList.add(new node(i, j));
					}
				}
			}
			
			dfs(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(minWire).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int idx, int core, int wire) {
		if(idx==coreList.size()) {
			if(maxCore<core) {
				maxCore=core;
				minWire=wire;
			} else if(maxCore==core) {
				minWire = Math.min(minWire, wire);
			}
			return;
		}
		
		int x = coreList.get(idx).x;
		int y = coreList.get(idx).y;
		
		for(int i=0; i<4; i++) {
			int cnt = 0;
			int nx = x;
			int ny = y;
			
			while(true) {
				nx += dx[i];
				ny += dy[i];
				
				if(0>nx || 0>ny || nx>N-1 || ny>N-1) break;
				
				if(map[nx][ny]==1) {
					cnt = 0;
					break;
				}
				
				cnt++;
			}
			
			int fill_nx = x;
			int fill_ny = y;
			
			for(int j=0; j<cnt; j++) {
				fill_nx += dx[i];
				fill_ny += dy[i];
				map[fill_nx][fill_ny] = 1;
			}
			
			if(cnt==0) {
				dfs(idx+1, core, wire);
			} else {
				dfs(idx+1, core+1, wire+cnt);
				
				fill_nx = x;
				fill_ny = y;
				
				for(int j=0; j<cnt; j++) {
					fill_nx += dx[i];
					fill_ny += dy[i];
					map[fill_nx][fill_ny] = 0;
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