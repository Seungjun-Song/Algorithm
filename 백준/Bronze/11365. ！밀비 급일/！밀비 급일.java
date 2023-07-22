import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringBuffer sb = new StringBuffer(br.readLine());
			if(sb.toString().equals("END")) {
				break;
			}
			System.out.println(sb.reverse());
		}
	}

}