import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            String str = br.readLine();
            if(str.length()>5) {
                stack.push(Integer.parseInt(str.substring(5)));
            }
            else {
                switch (str) {
                    case "pop":
                        System.out.println(stack.empty() ? -1 : stack.pop());
                        break;
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "empty":
                        System.out.println(stack.empty() ? 1 : 0);
                        break;
                    case "top":
                        System.out.println(stack.empty() ? -1 : stack.peek());
                        break;
                }
            }
        }
    }
}