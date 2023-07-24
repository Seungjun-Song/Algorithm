import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			if(s.length() >= M)
				map.put(s, map.getOrDefault(s, 0)+1);
		}
		
		// 빈도순 -> 길이순 -> 사전순
		List<String> keyList = new ArrayList<>(map.keySet());
		keyList.sort((s1, s2) -> {
			int c1 = map.get(s1);
			int c2 = map.get(s2);
			
			if(c1 == c2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				return s2.length() - s1.length();
			}
			return c2 - c1;
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<keyList.size(); i++) {
			sb.append(keyList.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}