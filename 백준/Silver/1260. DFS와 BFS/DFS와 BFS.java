import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, V;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(ArrayList<Integer> list : graph) {
            Collections.sort(list);
        }

        dfs(V);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(V);

        System.out.println(sb);
    }

    static void dfs(int idx) {
        if(!visited[idx]) {
            visited[idx] = true;
            sb.append(idx).append(" ");
            for(int i=0; i<graph.get(idx).size(); i++){
                if(!visited[graph.get(idx).get(i)])
                    dfs(graph.get(idx).get(i));
            }
        }
    }

    static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        visited[idx] = true;

        while (!queue.isEmpty()) {
            int q = queue.poll();
            sb.append(q).append(" ");

            for (int i : graph.get(q)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}