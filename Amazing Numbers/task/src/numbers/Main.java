package numbers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
        promtStart(scanner);
    }

    public static void promtStart (Scanner scanner) {
        System.out.println();
        System.out.println("Enter a request:");
        String input = scanner.nextLine();
        char ch = ' ';
        char check;

        for (int i = 0; i< input.length() - 1; i++) {
            check = input.charAt(i);
            if (check == ch) {
                String[] inputTwo = input.split(" ");
            } else {

            }
        }
        long number = Long.parseLong(input);
        checkInput(number, scanner);



    }

    public static void checkInput (long number, Scanner scanner) {

        if (number < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            promtStart(scanner);
        } else if (number == 0){
            System.out.println();
            System.out.println("Goodbye!");
            return;
        } else {
            naturalOrNot(number, scanner);
        }
    }

    private static void naturalOrNot (long number, Scanner scanner) {
        if (number < 1) {
            System.out.println("This number is not natural!");
            return;
        } else {
            checkProperties(number, scanner);
        }
    }

    private static void checkProperties (long number, Scanner scanner) {
        System.out.println("Properties of " + number);
        System.out.println("buzz: " + checkForBuzz(number));
        System.out.println("duck: " + checkForDuck(number));
        System.out.println("gapful: " + checkForGapful(number));
        System.out.println("palindromic: " + checkForPalindromic(number));
        System.out.println("even: " + checkForEven(number));
        System.out.println("odd: " + checkForOdd(number));
        promtStart(scanner);
    }

    private static boolean checkForGapful (long number) {

        System.out.println("gap " + number);
        /*
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }*/
        return true;
    }


    private static boolean checkForEven (long number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkForOdd (long number) {
        if (number % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkForDuck (long number) {

        String str = String.valueOf(number);
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

    private static boolean checkForBuzz (long number) {

        boolean isBuzz;
        if (number % 10 != 7 && number % 7 != 0) {
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