import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, K;
	static int map[][];
	static boolean visited[][];
	static PriorityQueue<node> pq = new PriorityQueue<>();
	static Queue<node> temp = new LinkedList<>();
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			N = r+2*K+4;
			M = c+2*K+4;
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i=N/2-1; i<N/2-1+r; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=M/2-1; j<M/2-1+c; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num!=0) {
						map[i][j] = num;
						visited[i][j] = true;
						pq.offer(new node(i, j, num, num*2));
					}
				}
			}
			
			bfs();
			sb.append("#").append(tc).append(" ").append(pq.size()).append("\n");
			pq.clear();
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		for(int t=0; t<K; t++) {
			while(!pq.isEmpty()) {
				node no = pq.poll();
				
				no.cur -= 1;
				
				if(no.orgin>no.cur) {
					for(int i=0; i<4; i++) {
						int nx = no.x + dx[i];
						int ny = no.y + dy[i];
						
						if(0>nx || 0>ny || nx>N || ny>M) continue;
						
						if(!visited[nx][ny]) {
							visited[nx][ny] = true;
							temp.add(new node(nx, ny, no.orgin, no.orgin*2));
						}
					}
				}
				
				if(no.cur!=0) temp.offer(new node(no.x, no.y, no.orgin, no.cur));
			}
			
			while(!temp.isEmpty()) {
				pq.offer(temp.poll());
			}
		}
	}
	
	static class node implements Comparable<node>{
		int x, y, orgin, cur;

		public node(int x, int y, int orgin, int cur) {
			super();
			this.x = x;
			this.y = y;
			this.orgin = orgin;
			this.cur = cur;
		}

		@Override
		public int compareTo(Solution.node o) {
			return -Integer.compare(cur, o.cur);
		}
	}
}