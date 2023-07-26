import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> a = new ArrayList<>();
		
		for(int i=0; i<3; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(a);
		
		System.out.println(a.get(1));
		
	}

}