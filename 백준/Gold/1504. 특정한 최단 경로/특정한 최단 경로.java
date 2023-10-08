import java.io.*;
import java.util.*;

public class Main {
	static int N, E;
	static ArrayList<ArrayList<Edge>> graph;
	
	static class Edge implements Comparable<Edge> {
		int to, weight;
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());	
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int p1 = dijkstra(1, v1);
		int p2 = dijkstra(v1, v2);
		int p3 = dijkstra(v2, N);
		
		int p4 = dijkstra(1, v2);
		int p5 = dijkstra(v2, v1);
		int p6 = dijkstra(v1, N);
		
		int answer = -1;
		if(p1!=-1 && p2!=-1 && p3!=-1) answer = p1 + p2 + p3;
		if(p4!=-1 && p5!=-1 && p6!=-1) answer = Math.min(answer, p4 + p5 + p6);
		System.out.println(answer);
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<Main.Edge>();
		pq.offer(new Edge(start, 0));
		
		int dist[] = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge current = pq.poll();
			
			if(current.to == end) return dist[end];
			
			for(Edge edge : graph.get(current.to)) {
				if(dist[edge.to] > dist[current.to] + edge.weight) {
					dist[edge.to] = dist[current.to] + edge.weight;
					pq.offer(new Edge(edge.to, dist[edge.to]));
				}
			}
		}
		return -1;
	}
}