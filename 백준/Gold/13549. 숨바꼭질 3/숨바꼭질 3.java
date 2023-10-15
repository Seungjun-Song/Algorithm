import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K, answer;
	static int[] visited;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	visited = new int[100001];
    	answer = Integer.MAX_VALUE;
    	
    	bfs();
    	System.out.println(answer-1);
    }
    
    static void bfs() {
    	Queue<node> q = new LinkedList<>();
    	q.offer(new node(N, 1));
    	while(!q.isEmpty()) {
    		node no = q.poll();
    		visited[no.x] = no.cnt;
    		
    		if(no.x == K) {
    			answer = Math.min(answer, no.cnt);
    			continue;
    		}
    		
    		int dx;
    		dx = no.x + 1;
    		if(0<=dx && dx<=100000)
    			if(visited[dx]==0 || visited[dx] > no.cnt+1)
    				q.offer(new node(dx, no.cnt+1));
    		
    		dx = no.x - 1;
    		if(0<=dx && dx<=100000)
    			if(visited[dx]==0 || visited[dx] > no.cnt+1)
    				q.offer(new node(dx, no.cnt+1));
    		
    		dx = no.x*2;
    		if(0<=dx && dx<=100000)
    			if(visited[dx]==0 || visited[dx] > no.cnt)
    				q.offer(new node(dx, no.cnt));
    	}
    }
    
    static class node {
    	int x, cnt;
    	
    	public node(int x, int cnt) {
    		this.x = x;
    		this.cnt = cnt;
    	}
    }
}