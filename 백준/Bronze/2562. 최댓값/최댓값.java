import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxNumber = 0;
        int position = 0;
        for (int i = 1; i < 10; i++) {
            int number = sc.nextInt();
            if (maxNumber < number) {
                maxNumber = number;
                position = i;
            }
        }

        System.out.println(maxNumber);
        System.out.println(position);
    }
}