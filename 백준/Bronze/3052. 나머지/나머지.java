import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 10; i++) {
            int n = sc.nextInt() % 42;
            if (!stack.contains(n)) {
                stack.push(n);
            }
        }

        System.out.println(stack.size());
    }
}