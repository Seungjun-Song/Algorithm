import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static char[] gender;
	static int[] parent;
	static ArrayList<Edge> edgeList;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        gender = new char[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
        	gender[i] = st.nextToken().charAt(0);
        }
        
        edgeList = new ArrayList<Edge>();
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	
        	edgeList.add(new Edge(u, v, d));
        }
        
        Collections.sort(edgeList);
        
        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
        	parent[i] = i;
        }

        int cnt = 0;
        int answer = 0;
        for(int i=0; i<M; i++) {
        	Edge edge = edgeList.get(i);
        	if(find(edge.start) != find(edge.end) && gender[edge.start] != gender[edge.end]) {
        		cnt++;
        		union(edge.start, edge.end);
        		answer += edge.weight;
        	}
        }
        
        System.out.println(cnt!=N-1 ? -1 : answer);
    }
    
    static int find(int x) {
    	if(parent[x]==x) {
    		return x;
    	}
    	return parent[x] = find(parent[x]);
    }
    
    static void union(int x, int y) {
    	x = find(x);
    	y = find(y);
    	
    	if(x!=y) {
    		parent[y] = x;
    	}
    }
}

class Edge implements Comparable<Edge> {
	int start, end, weight;

	public Edge(int start, int end, int weight) {
		super();
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		return weight-o.weight;
	}
}