import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());
        
        // w = 아랫변
        // w1 = 좌측 삼각형의 닮은 꼴인 작은 삼각형의 아랫변 
        // w2 = 우측 삼각형의 닮은 꼴인 작은 삼각형의 아랫변
        // h1 = 왼쪽 삼각형 세로 길이
        // h2 = 오른쪽 삼각형 세로 길이
        
//        w : w1 = h1 : c
//        w1h1 = wc
//        w1 = wc / h1 // w1 길이 구함
//        
//        w : w2 = h2 : c
//        w2h2 = wc
//        w2 = wc / h2 // w2 길이 구함
//        
//        w = wc / h1 + wc / h2 // w1+w2 = w와 같음
//        w = wc(1 / h1 + 1 / h2)
//        1 = c(1 / h1 + 1 / h2) 
//        1 = c(h1+h2 / h1h2)
//        c = h1h2 / h1+h2 // c 길이 구함
//        
//        h1**2 + w**2 = x**2 // 피타고라스 정리
//        h1**2 = x**2 - w**2
//        h1 = Math.sqrt(x**2 - w**2) // h1 길이 구함
//        h2**2 + w**2 = y**2 // 피타고라스 정리
//        h2**2 = y**2 - w**2
//        h2 = Math.sqrt(y**2 - w**2) // h2 길이 구함
       
        double low = 0;
        double high = Math.min(x, y);
        while(low+0.001 <= high) {
        	double w = (low + high) / 2;
        	
        	double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(w, 2));
        	double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(w, 2));
        	
        	double cc = (h1*h2) / (h1+h2);
        	if(cc >= c) {
        		low = w;
        	} else {
        		high = w;
        	}
        }
        
        System.out.printf("%.3f", high);
    }
}