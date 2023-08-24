import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	static int T, K, answer;
	static int arr[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 BufferedReader 선언
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			answer = 0;
			K = Integer.parseInt(br.readLine());
			
			arr = new int[4][8];
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int number = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				int margnet[] = new int[4];
				int dir[] = {-1, -1, -1, -1};
				
				switch(number) {
				case 1:
					margnet[0]++;
					if(arr[0][2]!=arr[1][6]) {
						margnet[1]++;
						if(arr[1][2]!=arr[2][6]) {
							margnet[2]++;
							if(arr[2][2]!=arr[3][6]) {
								margnet[3]++;
							}
						}
					}
					if(direction>0) {
						dir[0] = 1;
						dir[2] = 1;	
					} else {
						dir[1] = 1;
						dir[3] = 1;	
					}
					break;
				case 2:
					margnet[1]++;
					if(arr[0][2]!=arr[1][6]) {
						margnet[0]++;
					}
					if(arr[1][2]!=arr[2][6]) {
						margnet[2]++;
						if(arr[2][2]!=arr[3][6]) {
							margnet[3]++;
						}
					}
					if(direction>0) {
						dir[1] = 1;
						dir[3] = 1;	
					} else {
						dir[0] = 1;
						dir[2] = 1;	
					}
					break;
				case 3:
					margnet[2]++;
					if(arr[2][2]!=arr[3][6]) {
						margnet[3]++;
					}
					if(arr[1][2]!=arr[2][6]) {
						margnet[1]++;
						if(arr[0][2]!=arr[1][6]) {
							margnet[0]++;
						}
					}
					if(direction>0) {
						dir[0] = 1;
						dir[2] = 1;	
					} else {
						dir[1] = 1;
						dir[3] = 1;	
					}
					break;
				case 4:
					margnet[3]++;
					if(arr[2][2]!=arr[3][6]) {
						margnet[2]++;
						if(arr[1][2]!=arr[2][6]) {
							margnet[1]++;
							if(arr[0][2]!=arr[1][6]) {
								margnet[0]++;
							}
						}
					}
					if(direction>0) {
						dir[1] = 1;
						dir[3] = 1;	
					} else {
						dir[0] = 1;
						dir[2] = 1;	
					}
					break;
				}
				
				for(int j=0; j<4; j++) {
					if(margnet[j]==1)
						turnMargnet(j, dir);
				}
			}
			
			answer += arr[0][0]==0 ? 0 : 1;
			answer += arr[1][0]==0 ? 0 : 2;
			answer += arr[2][0]==0 ? 0 : 4;
			answer += arr[3][0]==0 ? 0 : 8;
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void turnMargnet(int num, int[] d) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		for(int i=0; i<8; i++) {
			q.offer(arr[num][i]);
		}
		
		if(d[num]>0) {
			q.addFirst(q.pollLast());
		} else {
			q.add(q.poll());
		}
		
		for(int i=0; i<8; i++) {
			arr[num][i] = q.poll();
		}
	}
}