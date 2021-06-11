package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameters show how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and a property to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");

        promptEnterRequest(scanner);
    }

    private static void promptEnterRequest (Scanner scanner) {
        System.out.println();
        System.out.println("Enter a request:");

        String input = scanner.nextLine();
        String[] ints = input.split(" ");
        String numberOne = ints[0];
        checkInput(scanner, input, ints);
    }

    private static void checkInput (Scanner scanner, String input, String[] ints) {

        String state = "";
        if (!Character.isDigit(input.charAt(0))) {
            System.out.println("The first parameter should be a natural number or zero.");
            state = "notDigit";
        } else if (input == "0") {
            state = "zero";
        }

        switch (state) {
            case "notDigit":
                promptEnterRequest(scanner);
                return;
            case "zero":
                System.out.println("Goodbye!");
                return;
        }

        int numberLength = 0;

        if (ints.length == 1) {
            numberLength = 1;
        } else if (ints.length == 2) {
            numberLength = 2;
        } else if (ints.length == 3) {
            numberLength = 3;
        }

        long number = Long.parseLong(ints[0]);

        switch (numberLength) {
            case 1:
                if (number <= -1) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    promptEnterRequest(scanner);
                    return;
                } else if (number >= 1) {
                    naturalOrNot(number, scanner);
                    return;
                }
                break;

            case 2:

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
                break;

            case 3:
                String number3 = ints[2];
                filterByProperties(ints, scanner);
                break;
        }
    }

    private static void naturalOrNot (long number, Scanner scanner) {
        if (number < 0) {
            System.out.println("This number is not natural!");
            return;
        } else {
            checkPropertiesOneNumber(scanner, number);
        }
    }

    private static void processTwoInts (String[] ints, Scanner scanner) {
        String numberOne = ints[0];
        String numberTwo = ints[1];
        long number1 = Long.parseLong(numberOne);
        int indexTwo = Integer.parseInt(numberTwo);
        int result = -1;

        for (int i = 0; i < indexTwo; i++) {
            result++;
            long number = number1 + (result);

            System.out.print(number + " is ");
            System.out.print((checkForEven(number)) ? "even" : "odd");
            System.out.print((checkForBuzz(number)) ? ", buzz" : "");
            System.out.print((checkForDuck(number)) ? ", duck" : "");
            System.out.print((checkForPalindromic(number)) ? ", palindromic" : "");
            System.out.print((checkForGapfulTwoNumber(number)) ? ", gapful" : "");
            System.out.print((checkForSpy(number)) ? ", spy" : "");
            System.out.println();
        }
        promptEnterRequest(scanner);
    }

    private static void filterByEven (String[] ints, Scanner scanner) {

        String numberOne = ints[0];
        long number = Long.parseLong(numberOne);
        int numberTwo = Integer.parseInt(ints[1]);
        int counter = 0;

        while (counter != numberTwo) {
            if (checkForEven(number)) {
                printByChosenProperties(number);
                counter++;
                number++;
            } else if (!checkForEven(number)) {
                number += 1;
            }
        }
        promptEnterRequest(scanner);
    }

    private static void filterByOdd (String[] ints, Scanner scanner) {

        String numberOne = ints[0];
        long number = Long.parseLong(numberOne);
        int numberTwo = Integer.parseInt(ints[1]);
        int counter = 0;

        while (counter != numberTwo) {
            if (checkForOdd(number)) {
                printByChosenProperties(number);
                counter++;
                number++;
            } else if (!checkForOdd(number)) {
                number += 1;
            }
        }
        promptEnterRequest(scanner);
    }

    private static void filterByBuzz (String[] ints, Scanner scanner) {

        String numberOne = ints[0];
        long number = Long.parseLong(numberOne);
        int numberTwo = Integer.parseInt(ints[1]);
        int counter = 0;

        while (counter != numberTwo) {
            if (checkForBuzz(number)) {
                printByChosenProperties(number);
                counter++;
                number++;
            } else if (!checkForBuzz(number)) {
                number += 1;
            }
        }
        promptEnterRequest(scanner);
    }

    private static void filterByDuck (String[] ints, Scanner scanner) {

        String numberOne = ints[0];
        long number = Long.parseLong(numberOne);
        int numberTwo = Integer.parseInt(ints[1]);
        int counter = 0;

        while (counter != numberTwo) {
            if (checkForDuck(number)) {
                printByChosenProperties(number);
                counter++;
                number++;
            } else if (!checkForDuck(number)) {
                number += 1;
            }
        }
        promptEnterRequest(scanner);
    }

    private static void filterByPalindromic (String[] ints, Scanner scanner) {

        String numberOne = ints[0];
        long number = Long.parseLong(numberOne);
        int numberTwo = Integer.parseInt(ints[1]);
        int counter = 0;

        while (counter != numberTwo) {
            if (checkForPalindromic(number)) {
                printByChosenProperties(number);
                counter++;
                number++;
            } else if (!checkForPalindromic(number)) {
                number += 1;
            }
        }
        promptEnterRequest(scanner);
    }

    private static void filterByGapful (String[] ints, Scanner scanner) {

        String numberOne = ints[0];
        long number = Long.parseLong(numberOne);
        int numberTwo = Integer.parseInt(ints[1]);
        int counter = 0;

        while (counter != numberTwo) {
            if (checkForGapfulOneNumber(number)) {
                printByChosenProperties(number);
                counter++;
                number++;
            } else if (!checkForGapfulOneNumber(number)) {
                number += 1;
            }
        }
        promptEnterRequest(scanner);
    }

    private static void filterBySpy (String[] ints, Scanner scanner) {

        String numberOne = ints[0];
        long number = Long.parseLong(numberOne);
        int numberTwo = Integer.parseInt(ints[1]);
        int counter = 0;

        while (counter != numberTwo) {
            if (checkForSpy(number)) {
                printByChosenProperties(number);
                counter++;
                number++;
            } else if (!checkForSpy(number)) {
                number += 1;
            }
        }
        promptEnterRequest(scanner);
    }

    private static void printByChosenProperties (long number) {
        System.out.print(number + " is ");
        System.out.print((checkForEven(number)) ? "even, " : "");
        System.out.print((checkForOdd(number)) ? "odd, " : "");
        System.out.print((checkForBuzz(number)) ? "buzz, " : "");
        System.out.print((checkForDuck(number)) ? "duck, " : "");
        System.out.print((checkForPalindromic(number)) ? "palindromic, " : "");
        System.out.print((checkForGapfulOneNumber(number)) ? "gapful, " : "");
        System.out.print((checkForSpy(number)) ? "spy, " : "");
        System.out.println();
    }

    private static void filterByProperties (String[]ints,Scanner scanner){

        String number3 = ints[2];
        String numberThree = number3.toLowerCase();

        switch (numberThree) {
            case "even":
                filterByEven(ints, scanner);
                break;
            case "odd":
                filterByOdd(ints, scanner);
                break;
            case "buzz":
                filterByBuzz(ints, scanner);
                break;
            case "duck":
                filterByDuck(ints, scanner);
                break;
            case "palindromic":
                filterByPalindromic(ints, scanner);
                break;
            case "gapful":
                filterByGapful(ints, scanner);
                break;
            case "spy":
                filterBySpy(ints, scanner);
                break;
            default:
                System.out.println("The property " + numberThree.toUpperCase() + " is wrong.");
                System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD]");
                promptEnterRequest(scanner);
        }
    }

    private static boolean checkForSpy (long number) {

        String numberOne = String.valueOf(number);
        StringBuilder str = new StringBuilder(numberOne);

        boolean isSpy;
        int countSum = 0;
        int countMultiplication = 1;

        for (int i = 0; i < numberOne.length(); i++) {
            countSum += Integer.parseInt(String.valueOf(numberOne.charAt(i)));
        }

        for (int i = 0; i < numberOne.length(); i++) {
            if (numberOne.charAt(i) == '0') {
                return false;
            }
            countMultiplication = countMultiplication * Integer.parseInt(String.valueOf(numberOne.charAt(i)));

        }
        if (countSum == countMultiplication) {
            isSpy = true;
        } else {
            isSpy = false;
        }
        return isSpy;
    }

    private static boolean checkForGapfulOneNumber (long number) {

        boolean isGapful;
        String numberOne = String.valueOf(number);

        String check1 = numberOne.substring(0, 1);
        String check2 = numberOne.substring(numberOne.length() - 1, numberOne.length());
        String check3 = check1 + check2;

        long checkInt = Long.parseLong(check3);

        if (numberOne.length() < 3) {
            isGapful = false;
        } else if (number % checkInt == 0) {
            isGapful = true;
        } else {
            isGapful = false;
        }
        return isGapful;
    }

    private static boolean checkForGapfulTwoNumber (long number) {

        boolean isGapful;
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

    private static void checkPropertiesOneNumber (Scanner scanner, long number) {
        System.out.println("Properties of " + number);
        System.out.println("buzz: " + checkForBuzz(number));
        System.out.println("duck: " + checkForDuck(number));
        System.out.println("palindromic: " + checkForPalindromic(number));
        System.out.println("gapful: " + checkForGapfulOneNumber(number));
        System.out.println("spy: " + checkForSpy(number));
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

    private static boolean checkForPalindromic (long num) {

        boolean isPalindromic;
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