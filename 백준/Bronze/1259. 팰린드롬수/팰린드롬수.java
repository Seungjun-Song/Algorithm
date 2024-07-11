import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String s = sc.nextLine();
            if (s.equals("0")) {
                break;
            }

            boolean isPalindrome = true;

            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    isPalindrome = false;
                }
            }

            if (isPalindrome) System.out.println("yes");
            else System.out.println("no");
        }
    }
}