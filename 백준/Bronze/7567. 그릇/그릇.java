import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Stack<Character> stack = new Stack<Character>();
		int answer = 10;
		for(int i=0; i<s.length(); i++) {
			stack.push(s.charAt(i));
		}
		
		char last = stack.pop();
		for(int i=stack.size(); i>0; i--){
			if(last == stack.get(i-1)) {
				answer += 5;
			} else answer += 10;
			last = stack.pop();
		}
		System.out.println(answer);
	}

}