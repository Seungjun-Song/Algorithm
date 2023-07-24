import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String boom = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			stack.push(s.charAt(i));
			boolean flag = true;
			if(stack.size() >= boom.length()) {
				for(int j=0; j<boom.length(); j++) {
					if(stack.get(stack.size()-boom.length()+j) != boom.charAt(j))
						flag = false;
				}
				if(flag) {
					for(int k=0; k<boom.length(); k++) {
						stack.pop();
					}
				}
			}
		}
		
		if(stack.isEmpty()) System.out.println("FRULA");
		else {
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty())
				sb.append(stack.pop());
			System.out.println(sb.reverse());
		}
	}
}