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
        
        Arrays.sort(arr, (s1, s2) -> s2[0] - s1[0]);
        
        int sum = 0;
        boolean visited[] = new boolean[arr.length];
        for(int i=arr[0][0]; i>0; i--) {
        	int maxValue = 0;
        	int maxIndex = 0;
        	for(int j=0; j<arr.length; j++) {
        		if(i<=arr[j][0] && !visited[j]) {
        			if(maxValue < arr[j][1]) {
        				maxValue = arr[j][1];
        				maxIndex = j;
        			}
        		}
        	}
        	visited[maxIndex] = true;
			sum += maxValue;
        }
        System.out.println(sum);
    }    
}