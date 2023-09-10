import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, N, K, W;
	static int[] arr, indegree, dp;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			arr = new int[N+1];
			list = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				list[i] = new ArrayList<>();
			}
			
			indegree = new int[N+1];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				list[A].add(B);
				indegree[B]++;
			}
			
			W = Integer.parseInt(br.readLine());
			dp = new int[N+1];
			topologySort();
			System.out.println(dp[W]);
		}
	}
	
	static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) {
				dp[i] = arr[i];
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for(int i=0; i<list[current].size(); i++) {
				int next = list[current].get(i);
				dp[next] = Math.max(dp[current]+arr[next], dp[next]);
				indegree[next]--;
				if(indegree[next]==0) q.offer(next);
			}
		}
	}
}