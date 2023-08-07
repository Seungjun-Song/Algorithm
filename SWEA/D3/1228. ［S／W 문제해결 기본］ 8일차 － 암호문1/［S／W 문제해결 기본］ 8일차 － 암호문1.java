import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	static int N, M;
	static LinkedList<String> list = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			list.clear();
			
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				list.add(st.nextToken());
			}
			
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<M; i++) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken()); // index
				int y = Integer.parseInt(st.nextToken()); // cnt
				
				for(int j=x; j<x+y; j++) {
					list.add(j, st.nextToken());
				}
			}
			sb.append("#").append(t).append(" ");
			for(int i=0; i<10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
