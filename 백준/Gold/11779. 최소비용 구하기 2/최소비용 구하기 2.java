import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m, A, B;
	static int[] dist, route;
	static ArrayList<ArrayList<Edge>> edgeList; 
	
	static class Edge implements Comparable<Edge> {
		int to, weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Main.Edge o) {
			return weight-o.weight;
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	n = Integer.parseInt(br.readLine());
    	m = Integer.parseInt(br.readLine());
    	
    	edgeList = new ArrayList<>();
    	for(int i=0; i<=n; i++) {
    		edgeList.add(new ArrayList<>());
    	}
    	
    	for(int i=0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		int z = Integer.parseInt(st.nextToken());
    		
    		edgeList.get(x).add(new Edge(y, z));
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	A = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	
    	dijkstra();
    	System.out.println(dist[B]);
        
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(B);
    	while(route[B] != 0) {
    		stack.push(route[B]);
    		B = route[B];
    	}
    	
    	System.out.println(stack.size());
    	while(!stack.isEmpty()) {
    		System.out.print(stack.pop() + " ");
    	}
    }
    
    static void dijkstra() {
    	dist = new int[n+1];
    	Arrays.fill(dist, Integer.MAX_VALUE/2);
    	dist[A] = 0;
    	
    	route = new int[n+1];
    	
    	PriorityQueue<Edge> pq = new PriorityQueue<>();
    	pq.add(new Edge(A, 0));
    	while(!pq.isEmpty()) {
    		Edge current = pq.poll();
    		
    		if(dist[current.to]<current.weight) continue;
    		
    		for(Edge edge : edgeList.get(current.to)) {
    			if(dist[edge.to]>dist[current.to]+edge.weight) {
    				dist[edge.to]=dist[current.to]+edge.weight;

    				route[edge.to] = current.to;
    				
    				pq.add(new Edge(edge.to, dist[edge.to]));
    			}
    		}
    	}
    }
}