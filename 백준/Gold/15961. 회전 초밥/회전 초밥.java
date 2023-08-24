import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, d, k, c, start, answer=0;
	static int belt[], visited[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 BufferedReader 선언
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		belt = new int[2*N];
		for(int i=0; i<N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
			belt[i+N] = belt[i];
		}
		visited = new int[d+1];
		
		int sum = 0;
		for(int i=0; i<k; i++) {
			if(visited[belt[i]]==0) sum++;
			visited[belt[i]]++;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[c]==0) {
				answer = Math.max(answer, sum+1);
			} else {
				answer = Math.max(answer, sum);
			}
			
			visited[belt[i]]--;
			if(visited[belt[i]]==0) sum--;
			
			if(visited[belt[i+k]]==0) sum++;
			visited[belt[i+k]]++;
		}
		
		System.out.println(answer);
	}
}