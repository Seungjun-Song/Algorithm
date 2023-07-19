import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		Deque<Character> q = new ArrayDeque<>();
		boolean flag = false;
		String temp = "";
		String answer = "";
		for(int i=0; i<S.length(); i++) {
			if(S.charAt(i) == '<') {
				flag = true;
				StringBuilder sb = new StringBuilder(temp);
				temp = "";
				answer += sb.reverse();
			}
			if(flag) {
				q.add(S.charAt(i));
			} else {
				if(S.charAt(i) == ' ') {
					StringBuilder sb = new StringBuilder(temp);
					temp = "";
					answer += sb.reverse() + " ";
					continue;
				} else if(i == S.length()-1) {
					temp += S.charAt(i);
					StringBuilder sb = new StringBuilder(temp);
					temp = "";
					answer += sb.reverse() + " ";
					continue;
				}
				temp += S.charAt(i);
			}
			if(S.charAt(i) == '>') {
				flag = false;
				while(q.size() > 0) {
					answer += q.removeFirst();
				}
			}
			
		}
		System.out.println(answer);
		
	}

}
