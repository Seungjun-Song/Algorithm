import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int S = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++) {
        	int mv = 0; // 최대값(maxValue)
        	int mi = 0; // 최대값 인덱스(maxIndex)
        	
        	// 최대값 찾기
        	for(int j=i; j<Math.min(N, i+S+1); j++) {
        		if(mv<arr[j]) {
        			mv = arr[j];
        			mi = j;
        		}
        	}
        	
        	// 정렬
        	for(int j=mi; j>i; j--) {
    			int temp = arr[j];
    			arr[j] = arr[j-1];
    			arr[j-1] = temp;
        	}
        	
        	S -= (mi - i);
        	if(S<=0) break;
        }
        
        for(int a : arr) System.out.print(a + " ");
    }
}