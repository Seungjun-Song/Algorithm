import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Long minValue = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long A = Long.parseLong(st.nextToken());
		Long B = Long.parseLong(st.nextToken());
		
		dfs(A, B, 1);
		if(minValue == Long.MAX_VALUE) System.out.println(-1);
		else System.out.println(minValue);
	}
	
	private static void dfs(Long a, Long b, int cnt) {
		if(a.equals(b)) {
			if(minValue>cnt) minValue = Long.valueOf(cnt);
			return;
		}
		else if(a > b) {
			return;
		}
		// 2를 곱한다.
		dfs(a*2, b, cnt+1);
		// 1을 오른쪽에 추가한다.
		String s = Long.toString(a);
		s += 1;
		a = Long.parseLong(s);
		dfs(a, b, cnt+1);
	}
}
