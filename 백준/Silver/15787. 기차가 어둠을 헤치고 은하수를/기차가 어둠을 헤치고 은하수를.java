import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] train;

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        train = new int[N+1][20];
        for(int j=0; j<M; j++) {
        	String s[] = br.readLine().split(" ");
        	int command = Integer.parseInt(s[0]);
        	int i = Integer.parseInt(s[1]);
        	int x = 0;
        	if(s.length>2)
        		x = Integer.parseInt(s[2])-1;
        	
        	switch(command) {
	        	case 1: // i번째 기차에 x번째 좌석에 사람을 태워라. 이미 사람이 있다면 X
	        		train[i][x] = 1;
	    			break;
	        	case 2: // i번째 기차에 x번째 좌석에 사람을 내려라. 만약 사람이 없다면 X
	        		train[i][x] = 0;
	    			break;
	        	case 3: // i번째 기차 승객들이 한칸씩 뒤로간다. 20번째 자리에 사람이 있다면 하차
	        		for(int k=train[i].length-1; k>0; k--) {
	        			train[i][k] = train[i][k-1];
	        		}
	        		train[i][0]=0;
	    			break;
	        	case 4: // i번째 기차 승객들이 한칸씩 앞으로간다. 20번째 자리에 사람이 있다면 하차
	    			for(int k=0; k<train[i].length-1; k++) {
	        			train[i][k] = train[i][k+1];
	        		}
	    			train[i][train[i].length-1]=0;
	        		break;
	        }
        }
        
        Set<String> set = new HashSet<>();
        for(int j=1; j<=N; j++) {
        	set.add(Arrays.toString(train[j]));
        }
        System.out.println(set.size());
    }
}