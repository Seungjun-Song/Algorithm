import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int answer = -1;
	static int weight[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int answer = -1;
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 과자 봉지의 개수
			M = Integer.parseInt(st.nextToken()); // 무게 합 제한
			
			st = new StringTokenizer(br.readLine());
			weight = new int[N];
			for(int i=0; i<N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(weight);
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if(weight[i] + weight[j] <= M
							&& answer < weight[i] + weight[j])
						answer = weight[i] + weight[j];
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer);
			System.out.println(sb);
		}
	}
}
