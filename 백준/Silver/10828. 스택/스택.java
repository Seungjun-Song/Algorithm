import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int num = 0;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			if(s.contains("push")) {
				String temp[] = s.split(" ");
				s = temp[0];
				num = Integer.parseInt(temp[1]);
			}
			
			switch(s) {
			case "push":
				stack.add(num);
				break;
			case "pop":
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.pop());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "top":
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.peek());
				break;
			}
		}
	}
}