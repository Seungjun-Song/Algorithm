import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Tree {
	int x, y, z;
	
	public Tree(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static int N, M, K, answer;
	static int food[][], A[][];
	static Deque<Tree> trees;
	static int dx[] = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int dy[] = {1, 1, 1, 0, -1, -1, -1, 0};

	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        food = new int[N+1][N+1];
        A = new int[N+1][N+1];
        trees = new LinkedList<Tree>();
        
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=N; j++) {
        		A[i][j] = Integer.parseInt(st.nextToken());
        		food[i][j] = 5;
        	}
        }
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int z = Integer.parseInt(st.nextToken());
        	trees.add(new Tree(x, y, z));
        }
        
        for(int i=0; i<K; i++) {
        	Deque<Tree> deadTrees = new LinkedList<>();
        	// 봄
        	for(int j=0; j<trees.size(); j++) {
        		Tree tree = trees.poll();
        		if(food[tree.x][tree.y] < tree.z) {
        			deadTrees.add(tree);
        			j--;
        			continue;
        		}
        		food[tree.x][tree.y] -= tree.z;
        		tree.z += 1;
        		trees.add(tree);
        	}
        	// 여름
        	while(!deadTrees.isEmpty()) {
        		Tree dTree = deadTrees.poll();
        		food[dTree.x][dTree.y] += Math.floor(dTree.z/2);
        	}
        	// 가을
        	Deque<Tree> temp = new LinkedList<>();
        	for(Tree tree : trees) {
        		if(tree.z%5 == 0) temp.add(tree);
        	}
        	while(!temp.isEmpty()) {
        		breeding(temp.poll());
        	}
        	// 겨울
        	for(int j=1; j<=N; j++) {
        		for(int k=1; k<=N; k++) {
        			food[j][k] += A[j][k];
        		}
        	}
        }
        System.out.println(trees.size());
    }
	
	static void breeding(Tree tree) {
		for(int i=0; i<8; i++) {
			int nx = tree.x + dx[i];
			int ny = tree.y + dy[i];
			
			if(1<=nx && nx<=N && 1<=ny && ny<=N) {
				trees.addFirst(new Tree(nx, ny, 1));
			}
		}
	}
}