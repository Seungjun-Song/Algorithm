import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String NM[] = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		for(int i=0; i<N; i++) {
			StringBuffer sb = new StringBuffer(br.readLine());
			System.out.println(sb.reverse());
		}
	}

}