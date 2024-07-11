import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) answer.append(Character.toLowerCase(c));
            else answer.append(Character.toUpperCase(c));
        }

        System.out.println(answer);
    }
}