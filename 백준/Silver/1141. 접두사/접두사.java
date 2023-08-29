import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		String ss[] = new String[N];
		boolean check[] = new boolean[N];
		
		for(int i=0; i<N; i++) {
			ss[i] = br.readLine();
		}
		
		Arrays.sort(ss);
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(ss[j].contains(ss[i])) {
					if(ss[i].equals(ss[j].substring(0, ss[i].length()))) {
						check[i] = true;
					}
				}
			}
		}
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			if(check[i]==false)
				answer++;
		}
		System.out.println(answer);
		
		// if 포함되는지 확인
		// if 제일 앞자리부터 동일한지 체크
	}

}
