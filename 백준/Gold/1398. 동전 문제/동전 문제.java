import java.io.*;
import java.util.*;

public class Main {
	 
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	// 1부터 100까지 필요한 동전 갯수 배열 생성
    	int cost[] = new int[101];
    	Arrays.fill(cost, Integer.MAX_VALUE);
    	cost[1] = 1;
    	cost[10] = 1;
    	cost[25] = 1;
    	for(int i=2; i<101; i++) {
    		cost[i] = cost[i] < cost[i-1] + 1 ? cost[i] : cost[i-1] + 1;
    		if(i>10)
    			cost[i] = cost[i] < cost[i-10] + 1 ? cost[i] : cost[i-10] + 1;
    		if(i>25)
    			cost[i] = cost[i] < cost[i-25] + 1 ? cost[i] : cost[i-25] + 1;
    	}
    	
    	int T = Integer.parseInt(br.readLine());
    	for(int tc=0; tc<T; tc++) {
    		long choco = Long.parseLong(br.readLine());
    		int cnt = 0;
    		while(choco >= 1) {
    			// 초콜릿의 가격을 100으로 나누어 가며 필요한 코인의 갯수만큼 더해줌
    			if(choco%100 > 0) cnt += cost[(int) (choco%100)];
    			choco /= 100;
    		}
    		System.out.println(cnt);
    	}
    }   
}