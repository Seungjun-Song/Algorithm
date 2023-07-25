import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String NM[] = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int arr[] = new int[N];
		String aa[] = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(aa[i]);
		}
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			int sum = 0;
			for(int j=i; j<N; j++) {
				sum += arr[j];
				if(sum == M) {
					answer++;
					break;
				}
				if(sum > M) {
					break;
				}
			}
		}
		System.out.println(answer);
		
	}
}