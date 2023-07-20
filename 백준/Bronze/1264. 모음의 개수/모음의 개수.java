import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while(true) {
			s = br.readLine().toLowerCase();
			if(s.equals(null) || s.equals("#")) break;
			int cnt = 0;
			cnt += s.length() - s.replace("a", "").length();
			cnt += s.length() - s.replace("e", "").length();
			cnt += s.length() - s.replace("i", "").length();
			cnt += s.length() - s.replace("o", "").length();
			cnt += s.length() - s.replace("u", "").length();
			System.out.println(cnt);
		}
	}
}