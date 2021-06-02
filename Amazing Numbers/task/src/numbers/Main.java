package numbers;

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

    private static void promtStart(Scanner scanner) {
        System.out.println();
        System.out.println("Enter a request:");
        String input = scanner.nextLine();
        String[] ints = input.split(" ");
        String numberOne = ints[0];

        if (ints.length > 1) {
            stringToInts(ints);

        } else {
            stringToLong(ints, scanner, numberOne);
        }
    }

    private static void stringToInts(String[] ints) {  // case with 2 ints
        String numberOne = ints[0];

        processTwoInts(ints,numberOne);
    }

    private static void stringToLong(String[] ints, Scanner scanner, String numberOne) {
        long number = Long.parseLong(ints[0]);
        checkInput(number, scanner, numberOne);
    }

    private static void processTwoInts(String[] ints, String numberOne) {

        long number = Long.parseLong(numberOne);
        String numberTwo = ints[1];
        int indexTwo =Integer.parseInt(numberTwo);

        int result = -1;

        for (int i = 0; i < indexTwo; i++) {
            result++;
            long allSequence = number + (result);
            System.out.println(allSequence + " is " +
                    "buzz, " +
                    "duck, " +
                    "gapful, " +
                    "odd");
        }

}

    private static void checkInput (long number, Scanner scanner, String numberOne) {

        if (number < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            promtStart(scanner);
        } else if (number == 0){
            System.out.println();
            System.out.println("Goodbye!");
            return;
        } else {
            naturalOrNot(number, scanner, numberOne);
        }
    }

    private static void naturalOrNot (long number, Scanner scanner, String numberOne) {
        if (number < 1) {
            System.out.println("This number is not natural!");
            return;
        } else {
            checkProperties(number, scanner, numberOne);
        }
    }

    private static void checkProperties (long number, Scanner scanner, String numberOne) {
        System.out.println("Properties of " + number);
        System.out.println("buzz: " + checkForBuzz(number));
        System.out.println("duck: " + checkForDuck(number));
        System.out.println("palindromic: " + checkForPalindromic(number));
        System.out.println("gapful: " + checkForGapful(numberOne));
        System.out.println("even: " + checkForEven(number));
        System.out.println("odd: " + checkForOdd(number));
        promtStart(scanner);
    }

    private static boolean checkForGapful (String numberOne) {

       boolean isGapful = false;

        if (numberOne.length() < 3) {
            isGapful = false;
        }
        int numberInt = Integer.parseInt(numberOne);
        System.out.println("numberInt "+ numberInt);

        String check1 = numberOne.substring(0, 1);
        String check2 = numberOne.substring(numberOne.length() - 1, numberOne.length());
        String check3 = check1 + check2;

        int checkInt = Integer.parseInt(check3);

        if (numberInt % checkInt == 0) {
            isGapful = true;
            System.out.println("its Gapful!");
        } else {
            isGapful = false;
        }
        return isGapful;
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