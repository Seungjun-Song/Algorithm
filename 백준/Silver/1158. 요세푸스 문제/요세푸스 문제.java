import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			arr.add(i+1);
		}
		
		int idx = K-1;
		List<Integer> answer = new ArrayList<>();
		while(arr.size() > 0) {
			answer.add(arr.remove(idx));
			idx -= 1;
			for(int i=0; i<K; i++) {
				idx += 1;
				if(idx >= arr.size())
					idx -= arr.size();
			}
		}
		
		System.out.print("<");
		for(int i=0; i<answer.size(); i++) {
			if(i == answer.size()-1) System.out.print(answer.get(i));
			else System.out.print(answer.get(i) + ", ");
		}
		System.out.print(">");
		
	}
}