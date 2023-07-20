import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] array = new String[N];
		for(int i=0; i<N; i++) {
			array[i] = br.readLine();
		}
		
		int cnt = 0;
		int row = 0;
		int col = 0;
		// 가로
		for(int i=0; i<N; i++) {
			int h = 0, v = 0;
			for(int j=0; j<N; j++) {
				if(array[i].charAt(j) == '.') h++;
				if(array[i].charAt(j) == 'X' || (j == N-1)) {
					if(h>1) row++;
					h = 0;
				}
				if(array[j].charAt(i) == '.') v++;
				if(array[j].charAt(i) == 'X' || (j == N-1)) {
					if(v>1) col++;
					v = 0;
				}
			}
		}
		System.out.print(row + " " + col);
	}
}