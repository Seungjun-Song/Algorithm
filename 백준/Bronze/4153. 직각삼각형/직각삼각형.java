import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            if (x == 0 && y == 0 && z == 0) {
                break;
            }

            if (Math.pow(x, 2) + Math.pow(y, 2) == Math.pow(z, 2)) {
                System.out.println("right");
            } else if (Math.pow(x, 2) + Math.pow(z, 2) == Math.pow(y, 2)) {
                System.out.println("right");
            } else if (Math.pow(y, 2) + Math.pow(z, 2) == Math.pow(x, 2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}