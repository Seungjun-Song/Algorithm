import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int arr[][];
	static char cc[] = {'(', ')', '[', ']', '{', '}', '<', '>'};

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int t=1; t<=10; t++) {
        	N = Integer.parseInt(br.readLine());
            String s = br.readLine();
            
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<s.length(); i++) {
            	if(stack.isEmpty()) {
            		stack.add(s.charAt(i));
            		continue;
            	}
            	char c = stack.peek();
            	if(c == cc[0] && s.charAt(i) == cc[1])
            		stack.pop();
            	else if(c == cc[2] && s.charAt(i) == cc[3])
            		stack.pop();
            	else if(c == cc[4] && s.charAt(i) == cc[5])
            		stack.pop();
            	else if(c == cc[6] && s.charAt(i) == cc[7])
            		stack.pop();
            	else
            		stack.add(s.charAt(i));
            }
        	
        	if(stack.isEmpty()) System.out.println("#" + t + " " + 1); 
        	else System.out.println("#" + t + " " + 0);
        }
        
    }
}