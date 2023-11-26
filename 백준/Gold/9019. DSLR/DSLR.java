import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			Queue<Integer> q = new LinkedList<>();
			q.add(A);
			String[] command = new String[10000];
			Arrays.fill(command, "");
			boolean[] visited = new boolean[10000];
			visited[A] = true;
			while(!q.isEmpty()&&!visited[B]) {
				int n = q.poll();
				int D = (n*2) % 10000;
				int S = n == 0 ? 9999 : n-1;
				int L = (n%1000)*10 + n/1000;
				int R = (n%10)*1000 + n/10;
				
				if(!visited[D]) {
					q.add(D);
					visited[D] = true;
					command[D] = command[n] + "D";
				}
				
				if(!visited[S]) {
					q.add(S);
					visited[S] = true;
					command[S] = command[n] + "S";
				}
				
				if(!visited[L]) {
					q.add(L);
					visited[L] = true;
					command[L] = command[n] + "L";
				}
				
				if(!visited[R]) {
					q.add(R);
					visited[R] = true;
					command[R] = command[n] + "R";
				}
			}
			
			System.out.println(command[B]);
		}
	}
}