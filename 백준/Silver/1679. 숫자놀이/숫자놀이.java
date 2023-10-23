import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> l = new ArrayList<>();
        Set<Integer> nums = new HashSet<>();
        int k = 0;

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            l.add(num);
            nums.add(num);
        }

        k = scanner.nextInt();

        int maxProduct = Collections.max(l) * k + 2;
        int[] dp = new int[maxProduct];

        for (int i = 1; i < maxProduct; i++) {
            if (nums.contains(i)) {
                dp[i] = 1;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }
            if (dp[i] > k) {
                String s = (i % 2 == 0) ? "holsoon" : "jjaksoon";
                System.out.println(s + " win at " + i);
                break;
            }
        }
    }
}