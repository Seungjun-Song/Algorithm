import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		int answer = 0;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			if(s.equals("ENTER")) set.clear();
			else if(set.contains(s)) {
				continue;
			} else {
				set.add(s);
				answer++;
			}
		}
		System.out.println(answer);
	}
}