import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			String[] ss = br.readLine().split(" ");
			for(String s : ss) {
				StringBuilder sb = new StringBuilder(s);
				System.out.print(sb.reverse() + " ");
			}
			System.out.println();
		}
		br.close();
	}

}
