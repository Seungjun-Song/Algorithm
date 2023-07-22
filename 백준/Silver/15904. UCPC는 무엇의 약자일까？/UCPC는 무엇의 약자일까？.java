import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String UCPC = "UCPC";
		boolean flag = true;
		
		for(Character c : UCPC.toCharArray()) {
			if(s.contains(c.toString())) {
				s = s.substring(s.indexOf(c)+1);
			} else {
				flag = false;
				break;
			}
		}
		
		if(flag) System.out.println("I love UCPC");
		else System.out.println("I hate UCPC");
	}

}