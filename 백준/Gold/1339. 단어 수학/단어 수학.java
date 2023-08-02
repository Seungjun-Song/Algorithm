import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException{
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int alpha[] = new int[26];
        
        for(int i=0; i<N; i++) {
        	String s = br.readLine();
        	double x = Math.pow(10, s.length()-1);
        	for(int j=0; j<s.length(); j++) {
        		alpha[s.charAt(j) - 'A'] += x;
        		x /= 10;
        	}
        }
        
        Integer[] arrAlpha = Arrays.stream(alpha).boxed().toArray(Integer[]::new);
        Arrays.sort(arrAlpha, Collections.reverseOrder());
        int cnt = 9;
        int sum = 0;
        for(Integer i : arrAlpha) {
        	sum += i*cnt--;
        }
        System.out.println(sum);
    }
}

// 자릿수가 큰 것 ~ 자릿수가 작은 것 => 9 ~ 0
// 길이가 같을 때는 