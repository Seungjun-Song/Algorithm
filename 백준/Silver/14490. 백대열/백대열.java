import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String nm[] = br.readLine().split(":");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		int answer = 0;
		
		for(int i=n; i>0; i--) {
			if(n%i == 0 && m%i == 0) {
				answer = i;
				break;
			}
		}
		
		System.out.println(n/answer + ":" + m/answer);
	}

}