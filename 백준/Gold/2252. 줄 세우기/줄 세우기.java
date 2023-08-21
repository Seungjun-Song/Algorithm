import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int topo[];
	static List<List<Integer>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 BufferedReader 선언
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		topo = new int[N+1];
		
		// 인접리스트
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 비교횟수
		for(int i=0; i<M ;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph.get(A).add(B);
			topo[B]++; // 진입 차수 증가
		}
		
		// 풀이
		Queue<Integer> queue = new ArrayDeque<>();
		
		// 진입차수가 0인 번호를 queue 에 넣는다.
		for(int i=1; i<=N; i++) {
			if(topo[i]==0) {
				queue.offer(i);
			}
		}
		
		// queue를 이용해서 꺼내면서 연결을 끊고 다시 진입차수가 0인 학생을 queue에 담는다.
		while(!queue.isEmpty()) {
			int no = queue.poll();
			sb.append(no).append(" ");
			
			List<Integer> list = graph.get(no);
			int size = list.size();
			for(int i=0; i<size; i++) {
				int temp = list.get(i);
				topo[temp]--;
				if(topo[temp] == 0)
					queue.offer(temp);
			}
		}
		
		System.out.println(sb);
	}

}