
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K, X;
	static int INF = Integer.MAX_VALUE/2;
	static int dist[];
	static ArrayList<ArrayList<Edge>> edgeList;
	
	static class Edge implements Comparable<Edge>{
		int to, weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return weight-o.weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		edgeList = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			edgeList.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			edgeList.get(A).add(new Edge(B, 1));
		}
		
		dijkstra();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<=N; i++) {
			if(dist[i]==K)
				list.add(i);
		}
		
		if(list.isEmpty()) System.out.println(-1);
		else {
			for(Integer i : list)
				System.out.println(i);
		}
	}
	
	static void dijkstra() {
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[X] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(X, 0));
		while(!pq.isEmpty()) {
			Edge current = pq.poll();
			
			for(Edge edge : edgeList.get(current.to)) {
				if(dist[edge.to] > dist[current.to] + edge.weight) {
					dist[edge.to] = dist[current.to] + edge.weight;
					
					pq.offer(new Edge(edge.to, dist[edge.to]));
				}
			}
		}
	}
}