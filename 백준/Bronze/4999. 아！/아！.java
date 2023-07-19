import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String jaehwan = br.readLine();
		String doctor = br.readLine();
		int j = jaehwan.length() - jaehwan.replace("a", "").length();
		int d = doctor.length() - doctor.replace("a", "").length();
		if(j>=d) System.out.println("go");
		else System.out.println("no");
	}

}
