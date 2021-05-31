package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter 0 to exit.");
        promtStart(scanner);
    }

    public static void promtStart (Scanner scanner) {
        System.out.println();
        System.out.println("Enter a request:");
        long num = scanner.nextLong();
        checkInput(num, scanner);
    }

    public static void checkInput (long num, Scanner scanner) {

        if (num < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            promtStart(scanner);
        } else if (num == 0){
            System.out.println();
            System.out.println("Goodbye!");
            return;
        } else {
            naturalOrNot(num, scanner);
        }
    }

    private static void naturalOrNot (long num, Scanner scanner) {
        if (num < 1) {
            System.out.println("This number is not natural!");
            return;
        } else {
            checkProperties(num, scanner);
        }
    }

    private static void checkProperties (long num, Scanner scanner) {
        System.out.println("Properties of " + num);
        System.out.println("even: " + checkForEven(num));
        System.out.println("odd: " + checkForOdd(num));
        System.out.println("buzz: " + checkForBuzz(num));
        System.out.println("duck: " + checkForDuck(num));
        System.out.println("palindromic: " + checkForPalindromic(num));
        promtStart(scanner);
    }

    private static boolean checkForEven (long num) {
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkForOdd (long num) {
        if (num % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkForDuck (long num) {

        String str = String.valueOf(num);
        int count = 0;
        boolean isDuck = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count++;
            }

            if (str.charAt(0) == 0 && count == 1) {
                isDuck = false;
            } else if (str.charAt(0) != 0 && count >= 1) {
                isDuck = true;
            }
        }
        return isDuck;
    }

    private static boolean checkForBuzz (long num) {

        boolean isBuzz;
        if (num % 10 != 7 && num % 7 != 0) {
            isBuzz = false;
        } else {
            isBuzz = true;
        }
        return isBuzz;
    }

    private static boolean checkForPalindromic(long num) {

        boolean isPalindromic = false;
        String str = String.valueOf(num);
        String reverseStr = "";

        int idx = str.length();

            for (int i = (idx - 1); i >=0; --i) {
                reverseStr = reverseStr + str.charAt(i);
            }

                if (str.equals(reverseStr)) {
                    isPalindromic = true;
                } else if (num == 5) {
                    isPalindromic = true;
                } else {
                    isPalindromic = false;
                }
        return isPalindromic;
    }
}