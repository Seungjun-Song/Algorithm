import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, H, W, N, x, y;
	static char map[][];
	static int direction = 0; // 0 위 1 아래 2 왼쪽 3 오른쪽
	static String command;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			for(int i=0; i<H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					switch(map[i][j]) { // 0 위 1 아래 2 왼쪽 3 오른쪽
					case '^':
						x = i; y = j;
						direction = 0;
						break;
					case 'v':
						x = i; y = j;
						direction = 1;
						break;
					case '<':
						x = i; y = j;
						direction = 2;
						break;
					case '>':
						x = i; y = j;
						direction = 3;
						break;
					}
				}
			}
			
			N = Integer.parseInt(br.readLine());
			command = br.readLine();
			
			for(char c : command.toCharArray()) {
				switch(c) {
				case 'U':
					U();
					break;
				case 'D':
					D();
					break;
				case 'L':
					L();
					break;
				case 'R':
					R();
					break;
				case 'S':
					S();
					break;
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					sb.append(map[i][j]);
				}
				if(i==H-1) break;
				sb.append("\n");
			}
			System.out.println(sb);
		}
	}
	
	//	U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
	// 0 위 1 아래 2 왼쪽 3 오른쪽
	static void U() {
		direction = 0;
		map[x][y] = '^';
		if(0>x-1) return;
		if(map[x-1][y]=='.') {
			map[x][y] = '.';
			x -= 1;
			map[x][y] = '^';
		}
	}
	
	//	D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
	// 0 위 1 아래 2 왼쪽 3 오른쪽
	static void D() {
		direction = 1;
		map[x][y] = 'v';
		if(x+1>=H) return;
		if(map[x+1][y]=='.') {
			map[x][y] = '.';
			x += 1;
			map[x][y] = 'v';
		}
	}
	
	//	L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
	// 0 위 1 아래 2 왼쪽 3 오른쪽
	static void L() {
		direction = 2;
		map[x][y] = '<';
		if(0>y-1) return;
		if(map[x][y-1]=='.') {
			map[x][y] = '.';
			y -= 1;
			map[x][y] = '<';
		}
	}
	
	//	R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
	// 0 위 1 아래 2 왼쪽 3 오른쪽
	static void R() {
		direction = 3;
		map[x][y] = '>';
		if(y+1>=W) return;
		if(y<W && map[x][y+1]=='.') {
			map[x][y] = '.';
			y += 1;
			map[x][y] = '>';
		}
	}
	
	//	S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
	// 0 위 1 아래 2 왼쪽 3 오른쪽
	static void S() {
		switch(direction) {
		case 0:
			shoot(x, y, 0);
			break;
		case 1:
			shoot(x, y, 1);
			break;
		case 2:
			shoot(x, y, 2);
			break;
		case 3:
			shoot(x, y, 3);
			break;
		}
	}
	
	// 0 위 1 아래 2 왼쪽 3 오른쪽
	static void shoot(int nx, int ny, int dir) {
		while(0<=nx && nx<H && 0<=ny && ny<W) {
			if(map[nx][ny]=='*') {
				map[nx][ny]='.';
				break;
			} else if (map[nx][ny]=='#') {
				break;
			}
			if(dir==0)
				nx--;
			else if(dir==1)
				nx++;
			else if(dir==2)
				ny--;
			else if(dir==3)
				ny++;
		}
	}
}