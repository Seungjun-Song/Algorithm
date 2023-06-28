import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1; i<=T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int A[] = new int[N];
			int B[] = new int[M];
			for(int j=0; j<N; j++) {
				A[j] = sc.nextInt();
			}
			for(int j=0; j<M; j++) {
				B[j] = sc.nextInt();
			}
			
			int max = 0;
			if(N<M) {
				for(int k=0; k<M-N+1; k++) {
					int sum = 0;
					for(int l=0; l<N; l++) {
						sum += A[l]*B[l+k];
					}
					if(max<=sum) {
						max = sum;
					}
				}
			} else {
				for(int k=0; k<N-M+1; k++) {
					int sum = 0;
					for(int l=0; l<M; l++) {
						sum += A[l+k]*B[l];
					}
					if(max<=sum) {
						max = sum;
					}
				}
			}
			System.out.println("#" + i + " " + max);
		}
	}
}