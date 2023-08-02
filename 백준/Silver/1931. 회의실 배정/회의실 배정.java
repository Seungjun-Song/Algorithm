import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int d = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	arr[i][0] = d;
        	arr[i][1] = w;
        }
        
        Arrays.sort(arr, (s1, s2) -> {
        	if(s1[0] == s2[0]) return s1[1]-s2[1];
        	return s1[0] - s2[0];
        });
        
        int start = arr[0][0], end = arr[0][1], cnt = 1;
        for(int i=1; i<N; i++) {
        	if(start<=arr[i][0] && arr[i][1]<end) {
        		start = arr[i][0];
        		end = arr[i][1];
        	} else if(end<=arr[i][0]) {
        		start = arr[i][0];
        		end = arr[i][1];
        		cnt++;
        	}
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }    
}