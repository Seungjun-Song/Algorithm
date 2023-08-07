import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<int[]> q = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			while(!q.isEmpty()) {
				if(q.peek()[1] >= height) {
					sb.append(q.peek()[0]).append(" ");
					break;
				}
				q.pop();
			}
			
			if(q.isEmpty()) {
				sb.append("0 ");
			}
			q.push(new int[] {i, height});
		}
		System.out.println(sb);
	}

}
