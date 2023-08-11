import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int num[];
	static int tgt[];
	static int sum = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = new int[9];
		for(int i=0; i<9; i++) {
			num[i] = sc.nextInt();
		}
		
		tgt = new int[7];
		comb(0, 0);
	}
	
	static void comb(int s, int t) {
		if(t==7) {
			if(sum==100) {
				for(int i : tgt) {
					System.out.println(i);
				}
			}
			return;
		}
		
		if(s==9) return;
		
		tgt[t] = num[s];
		sum += tgt[t];
		comb(s+1, t+1);
		sum -= tgt[t];
		comb(s+1, t);
	}
	

}