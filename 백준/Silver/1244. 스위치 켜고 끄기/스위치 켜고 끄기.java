import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int switch_count = sc.nextInt();

        int[] switch_arr = new int[switch_count + 1];
        for (int i = 1; i <= switch_count; i++) {
            switch_arr[i] = sc.nextInt();
        }

        int student_count = sc.nextInt();
        for (int i = 0; i < student_count; i++) {
            int gender = sc.nextInt();
            int switch_number = sc.nextInt();

            if (gender == 1) {
                int multiply = 1;
                while (switch_number * multiply <= switch_count) {
                    switch_arr[switch_number * multiply] = switch_arr[switch_number * multiply] == 0 ? 1 : 0;
                    multiply += 1;
                }
            } else {
                switch_arr[switch_number] = switch_arr[switch_number] == 0 ? 1 : 0;
                int left = switch_number - 1, right = switch_number + 1;
                while (1 <= left && right <= switch_count
                    && switch_arr[left] == switch_arr[right]) {
                    switch_arr[left] = switch_arr[left] == 0 ? 1 : 0;
                    switch_arr[right] = switch_arr[right] == 0 ? 1 : 0;
                    left--;
                    right++;
                }
            }
        }

        for (int i = 1; i <= switch_count; i++) {
            System.out.print(switch_arr[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }
}