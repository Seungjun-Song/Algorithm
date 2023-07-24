import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String arr[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		int answer = 0;
		for(String a : arr) {
			answer += (s.length()-s.replace(a, "").length()) / a.length();
			s = s.replace(a, " ");
		}
		
		String b[] = s.split(" ");
		for(int i=0; i<b.length; i++) {
			answer += b[i].length();
		}
		System.out.println(answer);
	}
}