import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cctvCnt=0, min=Integer.MAX_VALUE;
    static int src[] = {0, 1, 2, 3};
    static int tgt[];
    static int map[][], temp[][];
    static List<node> cctv;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 BufferedReader 선언
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        temp = new int[N][M];
        cctv = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
                temp[i][j] = x;
                if(x!=0 && x!=6) {
                    cctv.add(new node(i, j, x));
                    cctvCnt++;
                }
            }
        }
        
        tgt = new int[cctv.size()]; // cctv가 어디를 바라보는지 확인하는 중복 순열 배열
        perm(0);
        System.out.println(min);
    }
    
    static void perm(int tgtIdx) {
        if(tgtIdx == tgt.length) {
            for(int i=0; i<tgt.length; i++) {
                fillMap(i, tgt[i]);
            }
            
            // 0 의 갯수 체크
            int blind = blindCheck();
            min = Math.min(min, blind);
            
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    map[i][j] = temp[i][j];
                }
            }
            return;
        }
        
        for(int i=0; i<4; i++) {
            tgt[tgtIdx] = src[i];
            perm(tgtIdx+1);
        }
    }
    
    static void fillMap(int cctvIdx, int d) {
        node temp = cctv.get(cctvIdx);
        
        int nx = temp.x;
        int ny = temp.y;
        int type = temp.num;
        
        switch(type) {
        case 1:
            while(true) {
                nx += dx[d];
                ny += dy[d];
                
                if(0>nx || nx>=N || 0>ny || ny>=M || map[nx][ny]==6) break;
                map[nx][ny] = 7;
            }
            break;
        case 2:
            for(int i=0; i<2; i++) {
                int D = (d + i*2) % 4;
                nx = temp.x;
                ny = temp.y;
                
                while(true) {
                    nx += dx[D];
                    ny += dy[D];
                    
                    if(0>nx || nx>=N || 0>ny || ny>=M || map[nx][ny]==6) break;
                    map[nx][ny] = 7;
                }
            }
            break;
        case 3:
            for(int i=0; i<2; i++) {
                int D = (d + i) % 4;
                nx = temp.x;
                ny = temp.y;
                
                while(true) {
                    nx += dx[D];
                    ny += dy[D];
                    
                    if(0>nx || nx>=N || 0>ny || ny>=M || map[nx][ny]==6) break;
                    map[nx][ny] = 7;
                }
            }
            break;
        case 4:
            for(int i=0; i<3; i++) {
                int D = (d + i) % 4;
                nx = temp.x;
                ny = temp.y;
                
                while(true) {
                    nx += dx[D];
                    ny += dy[D];
                    
                    if(0>nx || nx>=N || 0>ny || ny>=M || map[nx][ny]==6) break;
                    map[nx][ny] = 7;
                }
            }
            break;
        case 5:
            for(int i=0; i<4; i++) {
            	nx = temp.x;
                ny = temp.y;
                
                while(true) {
                    nx += dx[i];
                    ny += dy[i];
                    
                    if(0>nx || nx>=N || 0>ny || ny>=M || map[nx][ny]==6) break;
                    map[nx][ny] = 7;
                }
            }
            break;
        }
    }
    
    static int blindCheck() {
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
    
    static class node {
        int x, y, num;

        public node(int x, int y, int num) {
            super();
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

}