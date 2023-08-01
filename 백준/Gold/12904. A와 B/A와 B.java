import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder S = new StringBuilder(br.readLine());
		StringBuilder T = new StringBuilder(br.readLine());
		
		while(T.length() > S.length()) {
			if(T.charAt(T.length()-1) == 'A') {
				T.deleteCharAt(T.length()-1);
			} else {
				T.deleteCharAt(T.length()-1);
				T.reverse();
			}
		}
		
		if(T.toString().equals(S.toString())) System.out.println(1);
		else System.out.println(0);
	}

}
