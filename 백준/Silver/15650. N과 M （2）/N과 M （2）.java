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
	static int N;
	static int M;
	
	static int[] src;
	static int[] tgt;

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        src = new int[N];
        tgt = new int[M];
        
        for(int i=0; i<src.length; i++) {
        	src[i] = i+1;
        }
        
        comb(0, 0);
    }
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) {
			for(int i : tgt)
				System.out.print(i + " ");
			System.out.println();
			return;
		}
		
		if(srcIdx == src.length) return;
		tgt[tgtIdx] = src[srcIdx];
		comb(srcIdx+1, tgtIdx+1);
		comb(srcIdx+1, tgtIdx+0);
	}
}
