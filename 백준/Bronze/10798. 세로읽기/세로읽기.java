import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ss = new String[5];
		for(int i=0; i<5; i++) {
			ss[i] = br.readLine();
		}
		
		String s = "";
		for(int i=0; i<15; i++) {
			for(int j=0; j<5; j++) {
				if(ss[j].length() <= i) continue;
				s += ss[j].charAt(i);
			}
		}
		System.out.println(s);
	}

}
