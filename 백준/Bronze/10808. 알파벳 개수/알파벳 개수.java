import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int[] cnt = new int[26];
		
		for(int i=0; i<S.length(); i++) {
			cnt[S.charAt(i) - 97]++;
		}
		
		for(int i=0; i<cnt.length; i++) {
			System.out.print(cnt[i] + " ");
		}
	}

}
