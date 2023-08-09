import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<lecture> lectureList = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	lectureList.add(new lecture(Integer.parseInt(st.nextToken()),
        			Integer.parseInt(st.nextToken()),
        			Integer.parseInt(st.nextToken())));
        }
        Collections.sort(lectureList, (s1, s2) -> s1.start - s2.start);
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        int max = 1;
        for (int i=0; i<N; i++) {
        	while(!q.isEmpty() && q.peek()<=lectureList.get(i).start) {
        		q.poll();
        	}
        	
			q.add(lectureList.get(i).end);
			max = Math.max(max, q.size());
		}
        System.out.println(max);
    }
}

class lecture {
	int num;
	int start;
	int end;

	public lecture(int num, int start, int end) {
		this.num = num;
		this.start = start;
		this.end = end;
	}
}

/*
3 2 14
1 3 8
8 6 27
5 6 20
2 7 13
4 12 18
6 15 21
7 20 25
*/