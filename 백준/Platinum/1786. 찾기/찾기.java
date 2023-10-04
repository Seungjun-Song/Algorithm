import java.io.*;
import java.util.*;

public class Main {
	
	static String T, P;
	static int[] pi;
	static int cnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = br.readLine();
		P = br.readLine();
		pi = new int[P.length()];
		
		int j = 0;
		for(int i=1; i<P.length(); i++) {
			while(j>0 && P.charAt(i)!=P.charAt(j)) {
				j = pi[j-1];
			}
			
			if(P.charAt(i)==P.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		kmp(T, P);
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	static void kmp(String text, String pattern) {
		int tLength = text.length();
		int pLength = pattern.length();
		
		int j = 0;
		for(int i=0; i<tLength; i++) {
			
			while(j>0 && text.charAt(i)!=pattern.charAt(j)) {
				j = pi[j-1];
			}
			
			// 현재 text의 i번째 글자와 pattern의 j번째 글자가 일치하는 상황
			// => 2가지 경우 존재
			//   #1 : 모두 일치
			//   #2 : 일부 일치
			if(T.charAt(i)==P.charAt(j)) {
				if(j==pLength-1) { // 모두 일치
					cnt++;
					sb.append(i-j+1).append(" ");
					j = pi[j];
				} else { // 일부 일치
					j++;
				}
			}
		}
	}
	
}