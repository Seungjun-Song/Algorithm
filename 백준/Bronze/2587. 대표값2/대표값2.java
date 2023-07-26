import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		List<Integer> arr = new ArrayList<>();
		for(int i=0; i<5; i++) {
			int a = Integer.parseInt(br.readLine());
			sum += a;
			arr.add(a);
		}
		Collections.sort(arr);
		System.out.println(sum/5);
		System.out.println(arr.get(2));
	}

}