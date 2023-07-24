import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String s;
		int answer = 0;
		boolean flag;
		Stack<Character> stack;
		for(int i=0; i<N; i++) {
			s = br.readLine();
			flag = true;
			stack = new Stack<>();
			for(int j=0; j<s.length(); j++) {
				if(stack.empty()) stack.add(s.charAt(j));
				else {
					if(stack.contains(s.charAt(j))) {
						if(stack.peek().equals(s.charAt(j))) continue;
						else {
							flag = false;
							break;
						}
					} else {
						stack.add(s.charAt(j));
					}
				}
			}
			if(flag) answer ++;
		}
		System.out.println(answer);
	}
}