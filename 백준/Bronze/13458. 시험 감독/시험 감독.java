import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();			
		}
		int B = sc.nextInt();
		int C = sc.nextInt();
		long cnt = 0;
		
		for(int i=0 ; i<arr.length; i++) {
			
			if(arr[i] <= B) {
				cnt += 1;
				continue;
			} else {
				arr[i] -= B;
				cnt += 1;
				
				if(arr[i]%C == 0) cnt += arr[i]/C; 
				else cnt += arr[i]/C+1;				
			}
			
		}
		System.out.println(cnt);

	}

}