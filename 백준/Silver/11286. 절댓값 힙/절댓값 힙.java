import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						if(Math.abs(o1) == Math.abs(o2)) {
							return o1 - o2;
						} else
							return Math.abs(o1) - Math.abs(o2);
					}
		});
		
		for(int i=0; i<N; i++) {
			String info = br.readLine();
			if(info.equals("0")) {
				if(q.isEmpty()) {
					System.out.println(0);
					continue;
				}
				System.out.println(q.poll());
			} else {
				q.add(Integer.parseInt(info));
			}
		}
	}
}
