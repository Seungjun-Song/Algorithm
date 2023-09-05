import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		
		int left = 0, right = 0;
		long sum = 0, answer = 0;
		while(left<=right && right<N) {
			int minus = arr[right][0] - arr[left][0];
			
			if(minus<D) {
				sum += arr[right][1];
				right++;
			} else {
				sum -= arr[left][1];
				left++;
			}
			
			answer = Math.max(answer, sum);
		}
		
		System.out.println(answer);
	}

}
