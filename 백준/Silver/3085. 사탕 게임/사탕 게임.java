import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, answer;
	static char arr[][];
	static char temp;

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i=0; i<N; i++) {
        	String s = br.readLine();
        	for(int j=0; j<N; j++) {
        		arr[i][j] = s.charAt(j); 
        	}
        }
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N-1; j++) {
    			temp = arr[i][j];
    			arr[i][j] = arr[i][j+1];
    			arr[i][j+1] = temp;
    			cofirm();
    			temp = arr[i][j];
    			arr[i][j] = arr[i][j+1];
    			arr[i][j+1] = temp;
        		
    			temp = arr[j][i];
    			arr[j][i] = arr[j+1][i];
    			arr[j+1][i] = temp;
    			cofirm();
    			temp = arr[j][i];
    			arr[j][i] = arr[j+1][i];
    			arr[j+1][i] = temp;
        	}
        }
        
        System.out.println(answer);
    }
	
	static void cofirm() {
		for(int i=0; i<N; i++) {
			char c1 = arr[i][0];
			char c2 = arr[0][i];
			int cnt1 = 0;
			int cnt2 = 0;
			for(int j=0; j<N; j++) {
				if(c1==arr[i][j]) {
					cnt1++;
				} else {
					c1 = arr[i][j];
					cnt1 = 1;
				}
				
				if(c2==arr[j][i]) {
					cnt2++;
				} else {
					c2 = arr[j][i];
					cnt2 = 1;
				}
				
				if(answer<cnt1) answer = cnt1;
				if(answer<cnt2) answer = cnt2;
			}
		}
	}
}