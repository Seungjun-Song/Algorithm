import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int V, answer, temp;
	static boolean visited[];
	static ArrayList<node>[] graph;
	
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        V = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[V+1];
        for(int i=0; i<V+1; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        visited = new boolean[V+1];
        for(int i=1; i<=V; i++) {
        	st = new StringTokenizer(br.readLine());
        	int vertex = 0;
        	int x, y;
        	while((x = Integer.parseInt(st.nextToken())) != -1) {
        		if(vertex==0) {
        			vertex = x;
        			continue;
        		}
        		
        		y = Integer.parseInt(st.nextToken());
        		graph[vertex].add(new node(x, y));        		
        	}
        }

        answer = 0;
        
        visited = new boolean[V+1];
        dfs(graph[1].get(0).num, 0);
        
        visited = new boolean[V+1];
        dfs(temp, 0);
        System.out.println(answer);
    }
	
	static void dfs(int idx, int cnt) {
		visited[idx] = true;
		if(answer<cnt) {
			answer = cnt;
			temp = idx;
		}

		for(node no : graph[idx]) {
			if(!visited[no.num]) {
				dfs(no.num, cnt+no.dist);
			}
		}
	}
	
	static class node {
		int num, dist;

		public node(int num, int dist) {
			super();
			this.num = num;
			this.dist = dist;
		}
	}
}