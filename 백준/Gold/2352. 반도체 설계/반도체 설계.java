import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int lis[] = new int[n];
		lis[0] = arr[0];
		int idx = 1;
		int temp = 0;
		for(int i = 1; i<n; i++) {
			if(lis[idx-1]<arr[i])
				lis[idx++] = arr[i];
			else if(lis[0]>arr[i])
				lis[0] = arr[i];
			else {
				temp = Arrays.binarySearch(lis, 0, idx, arr[i]);
				lis[temp < 0 ? (-temp-1) : temp] = arr[i];
			}
		}
		
		System.out.println(idx);
	}

}
