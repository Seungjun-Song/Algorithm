import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	static int T, M, A, ans; // M = 이동 시간, BC = BC의 개수
	static int pathA[], pathB[]; // 두 사람이 움직이는 경로를 저장
	static BC[] bcArray; // 배터리 충전소의 배열
	static int ay, ax, by, bx; // a, b 두 사람의 y, x 좌표
	static int dy[] = {0, -1, 0, 1, 0};
	static int dx[] = {0, 0, 1, 0, -1};
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            pathA = new int[M];
            pathB = new int[M];
            
            // 사용자 A의 이동 정보
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
            	pathA[i] = Integer.parseInt(st.nextToken());
            }
            // 사용자 B의 이동 정보            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
            	pathB[i] = Integer.parseInt(st.nextToken());
            }
            
            bcArray = new BC[A];
            for(int i=0; i<A; i++) {
            	st = new StringTokenizer(br.readLine());
            	int X = Integer.parseInt(st.nextToken()); // BC X좌표
            	int Y = Integer.parseInt(st.nextToken()); // BC Y좌표
            	int C = Integer.parseInt(st.nextToken()); // BC 충전 범위
            	int P = Integer.parseInt(st.nextToken()); // BC 처리량
            	
            	bcArray[i] = new BC(Y, X, C, P);
            }
            
            // 초기화
            ans = 0;
            
            ay = 1;
            ax = 1;
            by = 10;
            bx = 10;
            
            // 풀이
            // 충전 
            charge(); // 시작 위치 충전
            // 이동 매 좌표마다 충전 - 충전할 때 마다 최대값을 선택해서 ans에 누적합
            for(int i=0; i<M; i++) {
            	ay += dy[pathA[i]];
            	ax += dx[pathA[i]];
            	by += dy[pathB[i]];
            	bx += dx[pathB[i]];
            	// 충전
            	charge();
            }
            
            // 출력
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
	}
	
	static void charge() {
		int max = 0;
		// 현재 ay, ax, by, bx 좌표에서 충전할 수 있는 최대 충전값을 구한 뒤 ans 누적합
		// 완탐
		// 모든 BC에 대해서
		//  위 BC에 대해 모든 BC에 대해서 고려 <= 이중 for
		for(int i=0; i<A; i++) {
			for(int j=0; j<A; j++) {
				int sum = 0;
				// a, b 각각 충전 시도
				int aPower = getPower(bcArray[i], ay, ax);
				int bPower = getPower(bcArray[j], by, bx);
				
				if(aPower == 0 && bPower == 0) continue; // 충전값이 없으면 skip
				
				// 둘다 충전되었거나, 어느 한쪽이 충전되었거나
				// 두 충전소가 같은 지, 다른지에 따라 구별 처리
				if(i != j) { // 두 충전소가 다른 경우
					sum = aPower + bPower;
				} else { // 두 충전소가 같은 경우
					// #1 a, b  둘다 충전한 경우 &&
					// 같은 충전소 aPower = bPower == 100 => 50 + 50 ? aPower 또는 bPower를 선택 
					// #2 a, b 중 한 쪽만 충전한 경우 => 한쪽은 0 => aPower 와 bPower 중 큰 값을 선택
					sum = Math.max(aPower, bPower);
				}
				max = Math.max(max, sum);
			}
		}
		ans += max;
	}
	// 충전소와 특정 좌표( y, x ) 에서 충전할 수 있는 power	
	static int getPower(BC bc, int y, int x) {
		if(Math.abs(bc.y - y) + Math.abs(bc.x - x) <= bc.c) return bc.p;
		return 0;
	}
	
	static class BC {
		int y, x, c, p;

		public BC(int y, int x, int c, int p) {
			super();
			this.y = y;
			this.x = x;
			this.c = c;
			this.p = p;
		}
	}
}