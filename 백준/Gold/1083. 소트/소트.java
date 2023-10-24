import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 배열 크기
        int[] nums = new int[n];    // 배열 nums
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int s = scanner.nextInt();  // 교환 횟수

        for (int i = 0; i < n; i++) {
            // 탐색
            int maxNum = Integer.MIN_VALUE;
            int maxIdx = -1;
            for (int j = i; j < Math.min(n, i + s + 1); j++) {
                if (nums[j] > maxNum) {
                    maxNum = nums[j];
                    maxIdx = j;
                }
            }
            // 교환
            for (int j = maxIdx; j > i; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
            // 후처리
            s -= (maxIdx - i);
            if (s <= 0) {
                break;
            }
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}