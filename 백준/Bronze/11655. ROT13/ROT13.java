import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String answer = "";
		for(int i=0; i<S.length(); i++) {
			if(S.charAt(i) == ' ') answer += " ";
			else if(65<=S.charAt(i) && S.charAt(i)<=90) {
				if(S.charAt(i)+13 > 90) answer += (char)(S.charAt(i)-13);
				else answer += (char)(S.charAt(i)+13);
			} else if(97<=S.charAt(i) && S.charAt(i)<=122) {
				if(S.charAt(i)+13 > 122) answer += (char)(S.charAt(i)-13);
				else answer += (char)(S.charAt(i)+13);
			} else {
				answer += S.charAt(i);
			}
			
		}
		System.out.println(answer);
	}

}
