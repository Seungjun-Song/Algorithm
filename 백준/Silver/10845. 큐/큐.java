import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
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
				q.offer(num);
				break;
			case "pop":
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.poll());
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				if(q.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "front":
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peek());
				break;
			case "back":
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(num);
				break;
			}
		}
	}
}