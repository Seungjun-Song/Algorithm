import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int map[][];
	static boolean visited[];

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = map[b][a] = 1;
		}
		
		int MV = Integer.MAX_VALUE, answer = 0;
		for(int i=1; i<=N; i++) {
			visited = new boolean[N+1];
			int x = bfs(i, 0);
			if(MV>x) {
				MV = x;
				answer = i;
			}
		}
		System.out.println(answer);
	}
	
	static int bfs(int idx, int count) {
		Queue<node> q = new ArrayDeque<>();
		q.offer(new node(idx, count));
		visited[idx] = true;
		while(!q.isEmpty()) {
			node no = q.poll();
			count += no.cnt;
			
			for(int i=1; i<=N; i++) {
				if(!visited[i] && map[no.i][i]==1) {
					visited[i] = true;
					q.offer(new node(i, no.cnt+1));
				}
			}
		}
		return count;
	}
	
	static class node {
		int i, cnt;

		public node(int i, int cnt) {
			super();
			this.i = i;
			this.cnt = cnt;
		}
	}
}