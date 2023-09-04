import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {

	 public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 BufferedReader 선언
		 StringTokenizer st;
		 
		 st = new StringTokenizer(br.readLine());
		 int n = Integer.parseInt(st.nextToken());
		 int k = Integer.parseInt(st.nextToken());
		 
		 long arr[] = new long[n];
		 st = new StringTokenizer(br.readLine());
		 for(int i=0; i<n; i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		 }
		 Arrays.sort(arr);
		 
		 long answer = 0;
		 for(int i=0; i<k; i++) {
			 answer += arr[i]*i;
		 }
		 for(int i=k; i<n; i++) {
			 answer += arr[i]*k;
		 }		 
		 
		 System.out.println(answer);
	}
 
}