import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String ss = br.readLine();
		int answer = 0;
		
		for(int i=1; i<n; i++) {
			String s = br.readLine();
			int cnt = 0;
			int[] word = new int[26];
			for(int j=0; j<ss.length(); j++) {
				word[ss.charAt(j) - 'A']++;
			}
			
			for(int j=0; j<s.length(); j++) {
				if(word[s.charAt(j) - 'A'] > 0) {
					cnt++;
					word[s.charAt(j) - 'A']--;
				}
			}
			
			if(ss.length() == s.length() && (ss.length() == cnt || ss.length() - 1 == cnt))
				answer++;
			else if(ss.length() - 1 == s.length() && ss.length() - 1 == cnt)
				answer++;
			else if(ss.length() + 1 == s.length() && ss.length() == cnt)
				answer++;
		}
		System.out.println(answer);
		
	}
}