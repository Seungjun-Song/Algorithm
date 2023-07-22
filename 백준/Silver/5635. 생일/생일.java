import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String arr[][] = new String[n][];
		String temp[];
		for(int i=0; i<n; i++) {
			temp = new String[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++)
				temp[j] = st.nextToken();
			arr[i] = temp;
		}
		
		String minName[] = arr[1];
		String maxName[] = arr[1];
		for(int i=0; i<n; i++) {
			if(Integer.parseInt(minName[3]) > Integer.parseInt(arr[i][3])) {
				minName = arr[i];
			} else if(Integer.parseInt(minName[3]) == Integer.parseInt(arr[i][3])) {
				if(Integer.parseInt(minName[2]) > Integer.parseInt(arr[i][2])) {
					minName = arr[i];
				} else if(Integer.parseInt(minName[2]) == Integer.parseInt(arr[i][2])) {
					if(Integer.parseInt(minName[1]) == Integer.parseInt(arr[i][1])) {
						minName = arr[i];
					}
				}
			}
				
			if(Integer.parseInt(maxName[3]) < Integer.parseInt(arr[i][3])) {
				maxName = arr[i];
			} else if(Integer.parseInt(maxName[3]) == Integer.parseInt(arr[i][3])) {
				if(Integer.parseInt(maxName[2]) < Integer.parseInt(arr[i][2])) {
					maxName = arr[i];
				} else if(Integer.parseInt(maxName[2]) == Integer.parseInt(arr[i][2])) {
					if(Integer.parseInt(maxName[1]) == Integer.parseInt(arr[i][1])) {
						maxName = arr[i];
					}
				}
			}
		}
		
		System.out.println(maxName[0]);
		System.out.println(minName[0]);
	}

}