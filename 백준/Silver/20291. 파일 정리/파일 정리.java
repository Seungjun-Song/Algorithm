import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[];
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			s = br.readLine().split("\\.");
			if(map.getOrDefault(s[1], null) == null) map.put(s[1], 1);
			else map.put(s[1], map.get(s[1])+1);
		}
		
		List<String> keyList = new ArrayList<>(map.keySet());
		keyList.sort((s1, s2) -> s1.compareTo(s2));
		for(String key : keyList) {
			System.out.println(key + " " + map.get(key));
		}
	}
	
}