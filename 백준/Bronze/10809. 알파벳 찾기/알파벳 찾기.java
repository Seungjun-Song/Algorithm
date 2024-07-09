import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        for (int i = 97; i < 123; i++) {
            System.out.print(S.indexOf(i) + " ");
        }
    }
}