import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		while((s = br.readLine()) != null) {
			int arr[] = new int[4];
			for(int i=0; i<s.length(); i++) {
				if(Character.isLowerCase(s.charAt(i))) arr[0]++;
				else if(Character.isUpperCase(s.charAt(i))) arr[1]++;
				else if(Character.isDigit(s.charAt(i))) arr[2]++;
			}
			arr[3] = s.length() - s.replace(" ", "").length();
			System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3]);
		}
	}
}