package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");

        promptEnterRequest(scanner);
    }

    private static void promptEnterRequest(Scanner scanner) {
        System.out.println();
        System.out.println("Enter a request:");
        String input = scanner.nextLine();
        String[] ints = input.split(" ");

        String numberOne = ints[0];
        long number = Long.parseLong(ints[0]);

        if (ints.length == 1) {
            if (number == 0) {
                System.out.println("Goodbye!");
                return;
            } else if (number <= -1) {
                System.out.println("The first parameter should be a natural number or zero.");
                promptEnterRequest(scanner);
                return;
            } else if (number >= 1) {
                naturalOrNot(numberOne, number, scanner);
                return;
            }

        } else if (ints.length == 2) {
            long number2 = Long.parseLong(ints[1]);

            if (number2 <= -1) {
                System.out.println("The second parameter should be a natural number.");
                promptEnterRequest(scanner);
                return;
            } else if (number <= -1) {
                System.out.println("The first parameter should be a natural number or zero.");
                promptEnterRequest(scanner);
                return;
            } else {
                processTwoInts(ints, scanner);
            }
        }
    }

    private static void processTwoInts(String[] ints, Scanner scanner) {
        String numberOne = ints[0];
        String numberTwo = ints[1];
        long number1 = Long.parseLong(numberOne);
        int indexTwo = Integer.parseInt(numberTwo);
        int result = -1;

        for (int i = 0; i < indexTwo; i++) {
            result++;
            long number = number1 + (result);

            System.out.print(number + " is ");
            System.out.print((checkForBuzz(number)) ? "buzz, " : "");
            System.out.print((checkForDuck(number)) ? "duck, " : "");
            System.out.print((checkForPalindromic(number)) ? "palindromic, " : "");
            System.out.print((checkForGapfulTwo(number)) ? "gapful, " : "");
            System.out.print((checkForEven(number)) ? "even" : "odd");
            System.out.println();
        }
        promptEnterRequest(scanner);
    }

    private static void naturalOrNot (String numberOne, long number, Scanner scanner) {
        if (number < 0) {
            System.out.println("This number is not natural!");
            return;
        } else {
            checkPropertiesOne(numberOne, scanner, number);
        }
    }

    private static boolean checkForGapfulOne (String numberOne) {

        boolean isGapful = false;
        long numberInt = Long.parseLong(numberOne);

        String check1 = numberOne.substring(0, 1);
        String check2 = numberOne.substring(numberOne.length() - 1, numberOne.length());
        String check3 = check1 + check2;

        long checkInt = Long.parseLong(check3);

        if (numberOne.length() < 3) {
            isGapful = false;
        } else if (numberInt % checkInt == 0) {
            isGapful = true;
        } else {
            isGapful = false;
        }
        return isGapful;
    }

    private static boolean checkForGapfulTwo (long number) {

        boolean isGapful = false;
        String numberTwo = String.valueOf(number);

        long numberInt = Long.parseLong(numberTwo);

        String check1 = numberTwo.substring(0, 1);
        String check2 = numberTwo.substring(numberTwo.length() - 1, numberTwo.length());
        String check3 = check1 + check2;

        int checkInt = Integer.parseInt(check3);

        if (numberTwo.length() < 3) {
            isGapful = false;
        } else if (numberInt % checkInt == 0) {
            isGapful = true;
        } else {
            isGapful = false;
        }
        return isGapful;
    }

    private static void checkPropertiesOne(String numberOne, Scanner scanner, long number) {
        System.out.println("Properties of " + number);
        System.out.println("buzz: " + checkForBuzz(number));
        System.out.println("duck: " + checkForDuck(number));
        System.out.println("palindromic: " + checkForPalindromic(number));
        System.out.println("gapful: " + checkForGapfulOne(numberOne));
        System.out.println("even: " + checkForEven(number));
        System.out.println("odd: " + checkForOdd(number));
        promptEnterRequest(scanner);
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