import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int INF = Integer.MAX_VALUE;
	static int[] dist;
	static boolean[] check;
	static ArrayList<node>[] graph;
	static PriorityQueue<node> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		dist = new int[N+1];
		check = new boolean[N+1];
		graph = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[v].add(new node(w, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		System.out.println(dist[end]);
	}
	
	static void dijkstra(int start) {
		Arrays.fill(dist, INF); // 거리 배열을 무한대로 초기화
		dist[start] = 0; // 거리 배열의 시작 지점을 0으로 초기화
		
		pq = new PriorityQueue<>();
		pq.offer(new node(start, 0));
		
		while(!pq.isEmpty()) {
			int nowVertex = pq.poll().index;
			
			if(check[nowVertex]) continue;
			check[nowVertex] = true;
			
			for(node next : graph[nowVertex]) {
				if(dist[next.index]>dist[nowVertex]+next.cost) {
					dist[next.index] = dist[nowVertex]+next.cost;
					
					pq.offer(new node(next.index, dist[next.index]));
				}
			}
		}
	}
	
	static class node implements Comparable<node> {
		int index, cost;
		
		node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		
		public int compareTo(node o) {
			return cost - o.cost;
		}
	}
}