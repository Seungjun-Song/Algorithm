import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int arr[];

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[2880];
		int goal[][] = new int[N][2];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int team = Integer.parseInt(st.nextToken());
			String times[] = st.nextToken().split(":");
			int time = Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
			goal[i][0] = time;
			goal[i][1] = team;
		}
		
		int winner = 0;
		for(int i=0; i<2880; i++) {
			
			for(int[] go : goal) {
				if(i==go[0]) {
					if(go[1]==1) 
						winner += 1;
					else if(go[1]==2)
						winner -= 1;
				}
			}
			if(winner>0)
				arr[i] = 1;
			else if(winner<0)
				arr[i] = 2;
		}
		
		int answer1 = 0, answer2 = 0;
		for(int a : arr) {
			if(a==1) answer1++;
			else if(a==2) answer2++;
		}
		
		System.out.printf("%02d:%02d\n", answer1/60, answer1%60);
		System.out.printf("%02d:%02d", answer2/60, answer2%60);
    }
	
}