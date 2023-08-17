import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, arr[][];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	arr[x][y] = arr[y][x] = 1;
        }
        
        int MV = Integer.MAX_VALUE;
        int answer = 0;
        for(int i=1; i<=N ;i++) {
        	visited = new boolean[N+1];
        	int x = bfs(i, 1);
        	if(MV>x) {
        		MV = x;
        		answer = i;
        	}
        }
        System.out.println(answer);
    }

	static int bfs(int idx, int cnt) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(idx, 0));
		visited[idx] = true;
		while(!q.isEmpty()) {
			node no = q.poll();
			cnt += no.y;
			
			for(int i=1; i<=N; i++) {
				int num = arr[no.x][i];
				
				if(num==1 && !visited[i]) {
					visited[i] = true;
					cnt+=1;
					q.offer(new node(i, no.y+1));
				}
			}
		}
		return cnt;
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