import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String P = sc.next();
		boolean flag = false;
		int[] table = makeTable(P);
		
		int idx = 0; // 현재 대응되는 글자 수
		for(int i=0; i< S.length(); i++) {
			// idx번 글자와 짚더미의 해당 글자가 불일치할 경우, 
			// 현재 대응된 글자의 수를 table[idx-1]번으로 줄인다.
			while(idx>0 && S.charAt(i) != P.charAt(idx)) {
				idx = table[idx-1];
			}
			// 글자가 대응될 경우	
			if(S.charAt(i) == P.charAt(idx)) {
				if(idx == P.length()-1) {
					flag = true;
					idx =table[idx];
				}else {
					idx += 1;
				}
			}
		}
		
		if(flag) System.out.println(1);
		else System.out.println(0);
	}
	
	static int[] makeTable(String pattern) {
		int n = pattern.length();
		int[] table = new int[n];
			
		int idx=0;
		for(int i=1; i<n; i++) {
	        // 일치하는 문자가 발생했을 때(idx>0), 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려준다.
			while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx-1];
			}
				
			if(pattern.charAt(i) == pattern.charAt(idx)) {
				idx += 1;
				table[i] = idx;  
			}
		}
		return table;
	}
	

}