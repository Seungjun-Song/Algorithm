import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int arr[] = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int plug[][] = new int[N][2];
        int cnt = 0;
        for(int i=0; i<plug.length; i++) {
        	plug[i][1] = Integer.MAX_VALUE;
        }
        for(int i=0; i<arr.length; i++) {
        	// 리스트에 일치하는 값이 있는지 boolean 체크
        	boolean flag = true;
        	for(int k=0; k<N; k++) {
        		if(plug[k][0] == arr[i]) {
        			flag = false;
        		}
        	}
        	// 리스트에 일치하는 값이 없어서 교체 알고리즘을 써야 될 때
        	if(flag) {
        		cnt++;
        		int idx = Integer.MAX_VALUE-1; // 이후에 출현하지 않으면 Integer.MAX_VALUE-1 처리
        		for(int j=i+1; j<arr.length; j++) {
        			// 현재 넣어야될 전기용품이 다음에 몇번째 인덱스에 또 출현하는지 체크
        			if(arr[i] == arr[j]) {
        				idx = j;
        				break;
        			}
        		}
        		
        		// 다음 번의 출현까지 오래 남은 idx,value 체크
        		int maxValue = 0, maxIdx = 0;
        		for(int j=0; j<plug.length; j++) {
        			if(maxValue < plug[j][1]) {
        				maxValue = plug[j][1];
        				maxIdx = j;
        			}
        		}
        		
        		// 출현 확률이 가장 낮은 플러그에 교체 알고리즘 적용
        		plug[maxIdx][0] = arr[i];
        		plug[maxIdx][1] = idx;
        	} else {
        		int idx = Integer.MAX_VALUE-1; // 이후에 출현하지 않으면 Integer.MAX_VALUE 처리
        		for(int j=i+1; j<arr.length; j++) {
        			// 현재 넣어야될 전기용품이 다음에 몇번째 인덱스에 또 출현하는지 체크
        			if(arr[i] == arr[j]) {
        				idx = j;
        				break;
        			}
        		}
        		
        		// 다음에 나올 출현 위치 갱신
        		int subIdx = 0;
        		for(int j=0; j<plug.length; j++) {
        			if(arr[i] == plug[j][0]) {
        				subIdx = j;
        			}
        		}
        		plug[subIdx][1] = idx;
        	}
        }
        if(cnt-N < 0) System.out.println(0);
        else System.out.println(cnt-N);
    }
}