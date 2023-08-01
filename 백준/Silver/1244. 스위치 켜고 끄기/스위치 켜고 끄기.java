import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException{
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int state[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	state[i] = Integer.parseInt(st.nextToken());
        }
        int num = Integer.parseInt(br.readLine());
        for(int i=0; i<num; i++) {
        	st = new StringTokenizer(br.readLine());
        	int gender = Integer.parseInt(st.nextToken());
        	int number = Integer.parseInt(st.nextToken());
        	
        	if(gender == 1) {
        		for(int j=0; j<N; j++) {
        			if((j+1) % number == 0) {
        				state[j] = state[j] == 0 ? 1 : 0;
        			}
        		}
        	} else if(gender == 2) {
        		state[number-1] = state[number-1] == 1 ? 0 : 1;
        		for(int j=1; j<N/2; j++) {
        			 if(number-j-1 < 0 || number+j-1 >= N) break;
        			 if(state[number-j-1] == state[number+j-1]) {
        				 state[number-j-1] = state[number-j-1] == 1 ? 0 : 1;
        				 state[number+j-1] = state[number+j-1] == 1 ? 0 : 1;
        			 }
        			 else break;
        		}
        	}
        }
        for(int i=0; i<state.length; i++) {
        	System.out.print(state[i] + " ");
        	if((i+1)%20 == 0) System.out.println();
        }
    }    
}