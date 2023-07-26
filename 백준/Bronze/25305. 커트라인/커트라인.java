import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Integer> arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr, Collections.reverseOrder());
		System.out.println(arr.get(k-1));
		
	}

}