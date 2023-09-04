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
		 int M = Integer.parseInt(st.nextToken());
		 
		 long arr[] = new long[M];
		 st = new StringTokenizer(br.readLine());
		 for(int i=0; i<M; i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		 }
		 
		 for(int i=1; i<M; i++) {
			 arr[i] += arr[i-1];
		 }
		 
		 for(int i=0; i<N; i++) {
			 long candy = Long.parseLong(br.readLine());
			 
			 int answer = bs(arr, candy, 0, M-1, Integer.MAX_VALUE);
			 if(answer==Integer.MAX_VALUE) System.out.println("Go away!");
			 else System.out.println(answer);
		 }
	}
	 
	 static int bs(long[] arr, long target, int start, int end, int answer) {
		 if(start>end) return answer;
		 int mid = (start+end) / 2;
		 
		 if(arr[mid]>=target) answer = Math.min(answer, mid+1); 
		 
		 if(arr[mid]>target) return bs(arr, target, start, mid-1, answer);
		 else if(arr[mid]<target) return bs(arr, target, mid+1, end, answer);
		 
		 return answer;
	 }

}