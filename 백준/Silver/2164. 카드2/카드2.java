import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	static int N;

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        Deque<Integer> deque = new LinkedList<>();
        for(int i=1; i<=N; i++) {
        	deque.add(i);
        }
        
        while(deque.size() > 1) {
        	deque.poll();
        	deque.add(deque.poll());
        }
        
        System.out.println(deque.poll());
    }
}