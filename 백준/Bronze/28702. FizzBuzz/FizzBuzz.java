import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the three previous FizzBuzz outputs
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String str3 = scanner.nextLine();
        
        // Find the current number based on the three given outputs
        int number1 = parseFizzBuzz(str1);
        int number2 = parseFizzBuzz(str2);
        int number3 = parseFizzBuzz(str3);

        // Calculate the base number
        int baseNumber = findBaseNumber(number1, number2, number3);
        
        // Calculate the next FizzBuzz output
        String nextOutput = getFizzBuzzOutput(baseNumber + 1);
        
        // Print the next FizzBuzz output
        System.out.println(nextOutput);
    }

    private static int parseFizzBuzz(String str) {
        switch (str) {
            case "FizzBuzz": return 15;
            case "Fizz": return 3;
            case "Buzz": return 5;
            default: return Integer.parseInt(str);
        }
    }

    private static int findBaseNumber(int num1, int num2, int num3) {
        int count = 1;
        while (true) {
            if (matches(count, num1) && matches(count + 1, num2) && matches(count + 2, num3)) {
                return count + 2;
            }
            count++;
        }
    }

    private static boolean matches(int count, int num) {
        if (num == 15) return count % 3 == 0 && count % 5 == 0;
        if (num == 3) return count % 3 == 0 && count % 5 != 0;
        if (num == 5) return count % 3 != 0 && count % 5 == 0;
        return count == num;
    }
    
    private static String getFizzBuzzOutput(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return Integer.toString(number);
        }
    }
}