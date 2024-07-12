import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        dfs(new Stack<>(), new boolean[N + 1], 0);
    }

    private static void dfs(Stack<Integer> stack, boolean[] visited, int number) {
        if (stack.size() == M) {
            for (Integer i : stack) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && i > number) {
                visited[i] = true;
                stack.push(i);
                dfs(stack, visited, i);
                stack.pop();
                visited[i] = false;
            }
        }
    }
}