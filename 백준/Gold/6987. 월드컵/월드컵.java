import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] win, draw, lose;
	static int[][] game;

	public static void main(String[] args) throws Exception {
		// 6승 불가
		// 5승 있을 시 패배 0
		// 승리 수 == 패배 수
		// 혼자서 과반수 승리 불가
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		win = new int[6];
		draw = new int[6];
		lose = new int[6];
		
		game = new int[15][2];
		int idx = 0;
		for(int i=0; i<5; i++) {
			for(int j=i+1; j<6; j++) {
				game[idx][0] = i;
				game[idx][1] = j;
				idx++;
			}
		}
		
		for(int t=0; t<4; t++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<6; i++) {
				sum += win[i] = Integer.parseInt(st.nextToken());
				sum += draw[i] = Integer.parseInt(st.nextToken());
				sum += lose[i] = Integer.parseInt(st.nextToken());
			}
			if(sum!=30) {
				System.out.print("0 ");
				continue;
			}
			
			if( dfs(0) ) System.out.print("1 ");
			else System.out.print("0 ");
		}
		
	}

	static boolean dfs(int idx) {
		if(idx==15) return true;
		int teamA = game[idx][0];
		int teamB = game[idx][1];
		
		if(win[teamA]>0 && lose[teamB]>0) {
			win[teamA]--;
			lose[teamB]--;
			if(dfs(idx+1)) return true;
			win[teamA]++;
			lose[teamB]++;
		}
		if(lose[teamA]>0 && win[teamB]>0) {
			lose[teamA]--;
			win[teamB]--;
			if(dfs(idx+1)) return true;
			lose[teamA]++;
			win[teamB]++;
		}
		if(draw[teamA]>0 && draw[teamB]>0) {
			draw[teamA]--;
			draw[teamB]--;
			if(dfs(idx+1)) return true;
			draw[teamA]++;
			draw[teamB]++;
		}
		return false;
	}
}