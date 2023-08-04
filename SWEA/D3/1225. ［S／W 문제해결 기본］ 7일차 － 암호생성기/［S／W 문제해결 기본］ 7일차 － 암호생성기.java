import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static int N, T;

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int t=1; t<=10; t++) {
        	T = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	Deque<Integer> deque = new LinkedList<>();
        	for(int i=0; i<8; i++) {
        		deque.add(Integer.parseInt(st.nextToken()));
        	}
        	int cnt = 1;
        	while(true) {
        		int rm = deque.removeFirst();
        		if(rm - cnt <= 0) {
        			deque.add(0);
        			break;
        		}
        		deque.add(rm-cnt++);
        		if(cnt>5) cnt = 1;
        	}
        	
        	System.out.print("#" + T + " ");
        	for(int i=0; i<8; i++) {
        		System.out.print(deque.poll() + " ");
        	}
        	System.out.println();
        }
    }
}