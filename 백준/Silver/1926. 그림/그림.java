import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt, sum, maxValue;
	static int arr[][];
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
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<M; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(arr[i][j] == 1 && !visited[i][j]) {
        			sum = 0;
        			cnt++;
        			bfs(i, j);
        			if(maxValue<sum)
        				maxValue=sum;
        		}
        	}
        }
        
        System.out.println(cnt);
        System.out.println(maxValue);
    }
	
	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y] = true;;
		
		while(!q.isEmpty()) {
			sum++;
			Point p = q.poll();
			int nx, ny;
			
			for(int i=0; i<4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M && arr[nx][ny]==1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
	}
}