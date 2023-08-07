import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	char x;
	int y;
	Node(char x, int y) {
	this.x = x;
	this.y = y;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Node> li = new ArrayList<>();
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());
	
			li.add(new Node(c, num));
		}
	
		Collections.sort(li, (s1, s2) -> s1.y - s2.y);
	
		boolean sameColor = true; // 같은 색깔 체크
		boolean continuityNumber = true; // 연속 숫자 체크
		int temp[][] = new int[10][2]; // 같은 숫자 체크[num, cnt]
	
		char startC = li.get(0).x;
		int startN = li.get(0).y;
		for(Node no : li) {
			if(startC != no.x) sameColor = false;
			if(startN != no.y) continuityNumber = false;
			startN++;
			temp[no.y][0] = no.y;
			temp[no.y][1] += 1;
		}
	
		Arrays.sort(temp, (s1, s2) -> s1[1] - s2[1]);
		
		int sameNumber[][] = new int[10][2];
		for(int i=1; i<=10; i++) {
			sameNumber[10-i][0] = temp[i-1][0];
			sameNumber[10-i][1] = temp[i-1][1];
		}
		
		// 같은색깔, 연속숫자는 무조건5
		// 같은숫자 갯수 배열에 체크
		int answer = 0;		
		if(sameColor && continuityNumber) { // 1.같은색깔5 연속숫자5
			answer = sameNumber[0][0] + 900;
		} else if(sameNumber[0][1]==4) { // 2.같은숫자4
			answer = sameNumber[0][0] + 800;
		} else if(sameNumber[0][1]==3 && sameNumber[1][1]==2) { // 3.같은숫자3 같은숫자2
			answer = sameNumber[0][0]*10 + sameNumber[1][0] + 700;
		} else if(sameColor) { // 4.같은색깔5
			answer = sameNumber[0][0] + 600;
		} else if(continuityNumber) { // 5.연속숫자5
			answer = sameNumber[0][0] + 500;
		} else if(sameNumber[0][1]==3) { // 6.같은숫자3
			answer = sameNumber[0][0] + 400;
		} else if(sameNumber[0][1]==2 && sameNumber[1][1]==2) { // 7.같은숫자2 같은숫자2
			answer = sameNumber[0][0]*10 + sameNumber[1][0] + 300;
		} else if(sameNumber[0][1]==2) { // 8.같은숫자2
			answer = sameNumber[0][0] + 200;
		} else { // 9.else
			answer = sameNumber[0][0] + 100;
		}
		System.out.println(answer);
	}

}