import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int N;
		HashMap<String, Integer> map;
		for(int tc=0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			for(int i=0; i<N; i++) {
				String arr[] = br.readLine().split(" ");
				if(map.getOrDefault(arr[1], null) == null) map.put(arr[1], 1);
				else map.put(arr[1], map.get(arr[1])+1);
			}
			
			int answer = 1;
			for(Integer i : map.values()) {
				answer *= (i+1);
			}
			System.out.println(answer-1);
		}
		
	}
}