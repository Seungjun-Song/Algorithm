import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, L;
	static int arr[][];
	static int snake[][];
	static int dx[] = {0, 0, 1, 0, -1};
	static int dy[] = {0, 1, 0, -1, 0};
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		snake = new int[N+1][N+1];
		snake[1][1] = 1;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		int headX = 1, headY = 1;
		int tailX = 1, tailY = 1;
		int direction = 1;
		int time = 0;
		int commandX[] = new int[L+1];
		String commandC[] = new String[L+1];
		for(int i=1; i<=L; i++) {
			st = new StringTokenizer(br.readLine());
			commandX[i] = Integer.parseInt(st.nextToken()); 
			commandC[i] = st.nextToken();
		}
		
		int X;
		String C;
		for(int i=1; i<=L; i++) {
			X = commandX[i] - commandX[i-1];
			C = commandC[i];
			boolean flag = false;
			
			for(int j=0; j<X; j++) {
				time++;
				
				headX += dx[direction];
				headY += dy[direction];
				// 뱀이 벽이나 자기자신의 몸과 부딪히면 게임 종료
				if(1>headX || headX>N || 1>headY || headY>N || snake[headX][headY]>0) {
					flag = true;
					break;
				}
				
				// 뱀 이동
				snake[headX][headY] = direction;
				if(arr[headX][headY]==0) {
					int dir = snake[tailX][tailY];
					snake[tailX][tailY] = 0;
					tailX += dx[dir];
					tailY += dy[dir];
				}
				arr[headX][headY] = 0;
			}
			
			if(flag) break;
			
			// 방향 전환(direction 유의)
			if(C.equals("L")) {
				direction -= 1;
				if(direction<1) direction = 4;
				snake[headX][headY] = direction;
			} else {
				direction += 1;
				if(direction>4) direction = 1;
				snake[headX][headY] = direction;
			}
			
			if(i==L && !flag) {
				while(true) {
					time++;
					
					headX += dx[direction];
					headY += dy[direction];
					// 뱀이 벽이나 자기자신의 몸과 부딪히면 게임 종료
					if(1>headX || headX>N || 1>headY || headY>N || snake[headX][headY]>0) {
						flag = true;
						break;
					}
					
					// 뱀 이동
					snake[headX][headY] = direction;
					if(arr[headX][headY]==0) {
						int dir = snake[tailX][tailY];
						snake[tailX][tailY] = 0;
						tailX += dx[dir];
						tailY += dy[dir];
					}
					arr[headX][headY] = 0;
				}
			}
		}
		
		System.out.println(time);
    }

}