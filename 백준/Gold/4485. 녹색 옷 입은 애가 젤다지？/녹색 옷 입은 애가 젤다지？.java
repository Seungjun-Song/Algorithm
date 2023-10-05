import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, k;
	static int INF = Integer.MAX_VALUE;
	static int[][] map, cost;
	static boolean visited[];
	static PriorityQueue<Edge> pqueue = new PriorityQueue<>();
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	static StringBuilder sb = new StringBuilder();
	
	static class Edge implements Comparable<Edge> { 
		int x, y, weight;

		public Edge(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight-o.weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			tc++;
			
			// 맵 입력 받기
			map = new int[N][N];
			cost = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = INF;
				}
			}
			
			dijkstra();
			
			sb.append("Problem ").append(tc).append(": ").append(cost[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dijkstra() {
		cost[0][0] = map[0][0];
		pqueue.offer(new Edge(0, 0, map[0][0]));
		
		while(!pqueue.isEmpty()) {
			Edge e = pqueue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = e.x + dx[d];
				int ny = e.y + dy[d];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				
				if(cost[nx][ny] > map[nx][ny] + e.weight) {
					cost[nx][ny] = map[nx][ny] + e.weight;
					
					pqueue.add(new Edge(nx, ny, cost[nx][ny]));
				}
			}
		}
	}
}