import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		HashMap<String, Integer> map = new HashMap<>();
		int cnt = 0;
		while((s = br.readLine()) != null) {
			if(map.getOrDefault(s, null) == null) map.put(s, 1);
			else map.put(s, map.get(s)+1);
			cnt++;
		}
		
		List<String> keyList = new ArrayList<>(map.keySet());
		keyList.sort((s1, s2) -> s1.compareTo(s2));
		for(String key : keyList) {
			System.out.printf("%s %.4f %n", key, (double)map.get(key)*100/cnt);
		}
	}

}