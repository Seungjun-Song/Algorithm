import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int N;
    private static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        dfs(1, new LinkedList<>());
    }

    private static void dfs(int start, List<Integer> list) {
        if (list.size() == M) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            list.add(i);
            dfs(i, list);
            list.remove(list.size() - 1);
        }
    }
}