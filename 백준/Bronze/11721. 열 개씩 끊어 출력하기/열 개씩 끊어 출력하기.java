import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		for(int i=0; i<S.length(); i+=10) {
			if(i+10 > S.length()) {
				System.out.println(S.substring(i));
				break;
			}
			System.out.println(S.substring(i, i+10));
		}

	}

}
