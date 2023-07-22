import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		boolean flag = true;
		int answer = 0;
		for(int i=0; i<s.length(); i++) {
			String temp = s.substring(i);
			flag = true;
			for(int j=0; j<temp.length(); j++) {
				if(temp.charAt(j) != temp.charAt(temp.length()-j-1)) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				answer += s.length() + i;
				break;
			}
		}
		System.out.println(answer);
	}

}