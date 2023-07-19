import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int N = Integer.parseInt(br.readLine());
		String s;
		
		for(int i=0; i<N; i++) {
			s = br.readLine();
			if(map.getOrDefault(s, null) == null) map.put(s, 1);
			else map.put(s, map.get(s)+1);
		}
		
		List<String> map2 = new ArrayList<>(map.keySet());
		Collections.sort(map2);
		
		int M = Collections.max(map.values());
		for(String a : map2) {
			if(map.get(a) == M) {
				System.out.println(a);
				break;
			}
		}
	}

}
