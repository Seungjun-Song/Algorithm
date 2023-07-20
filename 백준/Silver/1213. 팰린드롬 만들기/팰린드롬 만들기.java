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
		String s = br.readLine();
		HashMap<Character, Integer> map = new HashMap<>();
		String answer = "";
		for(char c : s.toCharArray()) {
			if(map.getOrDefault(c, null) == null) map.put(c, 1);
			else map.put(c, map.get(c)+1);
		}
		
		int cnt = 0;
		for(int i : map.values()) {
			if(i%2 == 1) {
				cnt++;
			}
		}
		
		if(cnt>1) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			List<Character> keyList = new ArrayList<>(map.keySet());
			Collections.sort(keyList);
			
			for(char c : keyList) {
				int n = map.get(c);
				if(n > 1) {
					for(int i=0; i<n/2; i++) {
						answer += c;
					}
				}
			}
			StringBuilder sb = new StringBuilder(answer);
			sb.reverse();
			
			for(char c : keyList) {
				if(map.get(c)%2 == 1) answer += c;
			}
			
			answer += sb;
		}
		System.out.println(answer);
	}
}