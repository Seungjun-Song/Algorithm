import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String arr[] = new String[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.next();
		}
		
		int cnt[];
		String answer = "";
		int maxValue = 0;
		for(int i=0; i<M; i++) {
			cnt = new int[4]; 
			for(int j=0; j<N; j++) {
				if(arr[j].charAt(i) == 'A') cnt[0]++;
				else if(arr[j].charAt(i) == 'T') cnt[3]++;
				else if(arr[j].charAt(i) == 'G') cnt[2]++;
				else if(arr[j].charAt(i) == 'C') cnt[1]++;
			}
			
			int maxIdx = 0;
			maxValue = 0;
			for(int k=0; k<4; k++) {
				if(maxValue<cnt[k]) {
					maxValue = cnt[k];
					maxIdx = k;
				}
			}
			
			if(maxIdx==0) answer += "A";
			else if(maxIdx==1) answer += "C";
			else if(maxIdx==2) answer += "G";
			else if(maxIdx==3) answer += "T";
		}
		
		int count = 0;
		for(String s : arr) {
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) != answer.charAt(i)) count++;
			}	
		}
		
		System.out.println(answer);
		System.out.println(count);
	}
}