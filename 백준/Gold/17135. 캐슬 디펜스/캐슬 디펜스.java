import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D, max;
	static int[] archer = new int[3]; // 조합으로 선택한 궁수의 x좌표
	static List<Enemy> enemyCopy = new ArrayList<>();
	static List<Enemy> enemy = new ArrayList<>(); // 시뮬레이션 과정에서 사용되는 (변하는 Enemy 를 관리)

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		int n = Integer.parseInt(st.nextToken());
        		if(n==1) enemyCopy.add(new Enemy(i, j));
        	}
        }
        
        comb(0, 0); // M 개 x 자리 ( y 는 맾 바로 밑 ) 에서 3개를 뽑아서 archer[] (tgt)에 담고 처리
        System.out.println(max);
	}
	
	static void check() {
		// 시뮬레이션 진행
		// 적군 초기화
		enemy.clear();
		for(Enemy e : enemyCopy) {
			enemy.add(new Enemy(e.y, e.x)); // 객체를 공유하지 않고, 내용만 복사
		}
		
		// while() 시물레이션 진행
		int dead = 0; // 죽인 적군의 수
		while(true) {
			// 궁수 3명이 한명씩 적군 쏜다.
			for(int i=0; i<3; i++) {
				// 가장 가까운 적??
				int minD = Integer.MAX_VALUE;
				int minX = Integer.MAX_VALUE;
				int minIdx = -1; // 가장 가까운 거리에 있는 적의 index
				int ac = archer[i]; // 현재 궁수의 x좌표
				int size = enemy.size(); // 현재 적군의 크기
				for(int j=0; j<size; j++) {
					Enemy e = enemy.get(j);
					int d = Math.abs(ac - e.x) + Math.abs(N - e.y);

					if( d>D ) continue;
					
					if( minD == d ) {
						if( minX > e.x ) {
							minX = e.x;
							minIdx = j;
						}
					} else if ( minD > d )  {
						minD = d;
						minX = e.x;
						minIdx = j;
					}
				}
				
				// minIdx 가 유요하면 (있으면)
				if( minIdx != -1 ) {
					enemy.get(minIdx).dead = true;
				}
			}
			// 죽은 적군을 enemy 제거, 남은 적군 한 칸 아래로 이동, 경계선을 벗어나면 enemy 에서 제거
			for(int i=enemy.size()-1; i>-1; i--) {
				Enemy e = enemy.get(i);
				if(e.dead) {
					enemy.remove(i);
					dead++;
				} else if(e.y == N-1) {
					enemy.remove(i);
				} else {
					e.y++;
				}
			}
			
			// 시물레이션 종료 조건
			if(enemy.size()==0) break;
		}
		
		max = Math.max(max, dead);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx==3) {
			// simulation
			check();
			return;
		}
		
		if(srcIdx==M) return;
		
		archer[tgtIdx] = srcIdx; // 궁수의 자리를 선택
		comb(srcIdx+1, tgtIdx+1); // 선택
		comb(srcIdx+1, tgtIdx); // 비선택
	}

	static class Enemy {
		int y, x, d; // d : 궁수와의 거리
		boolean dead; // 사망 여부
		
		Enemy(int y, int x) { // d, dead <= 시뮬레이션을 진행하면서 setting
			this.y = y;
			this.x = x;
		}
	}
}