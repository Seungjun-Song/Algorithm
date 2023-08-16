import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, halfN, min;
    static int[][] map;
    static boolean[] select; // 재료 선택 비선택
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());

            halfN = N/2;
            map = new int[N][N];
            select = new boolean[N];

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //풀이
            min = Integer.MAX_VALUE;
            comb(0,0);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
    }

    static void comb(int srcIdx, int tgtIdx) {
    	// N /2 개를 선택
    	if (tgtIdx == halfN) {
    		// complete code
    		check();
    		return ;
    	}
    	
    	if (srcIdx == N) return ;
    	
    	select[srcIdx]  = true;
    	comb(srcIdx + 1, tgtIdx + 1); // 현재 src 를 tgt에 선택
    	select[srcIdx] = false;
    	comb(srcIdx+1,tgtIdx);
    	
    }
    //select  배열에서 선택, 비선택 -> 두 그룹으로 나누어서 생각
    // 각각의 그룹별 sum 계산 후 차이 계산 후 min
    static void check() {
    	int sumA = 0;	// 선택
    	int sumB = 0;	// 비선택
    	//i,j로 모든 2개씩 조합
    	for(int i = 0; i < N -1 ; i ++) {
    		for(int j = i+1; j < N ; j ++) {
    			
    			if (select[i] && select[j]) { // 선택 된 그룹
    				sumA += map[i][j];
    				sumA += map[j][i];
    			}
    			else if (!select[i] && !select[j]) { //선택되지 않은 그룹
    				sumB += map[i][j];
    				sumB += map[j][i];
    			}
    		}
    	}
    	min = Math.min(min,Math.abs(sumA-sumB));
    }

}