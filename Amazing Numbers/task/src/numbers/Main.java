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
                "- two natural numbers and two properties to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
        promptEnterRequest(scanner);
    }

    private static void promptEnterRequest(Scanner scanner) {
        System.out.println();
        System.out.println("Enter a request:");
        String input = scanner.nextLine();

        if (input.equals("0")) {
            System.out.println("Goodbye!");
            return;
        } else {
            checkInput(scanner, input);
        }
    }

    private static void checkInput(Scanner scanner, String input) {
        String[] ints = input.split(" ");
        String state = "";

        if (!Character.isDigit(input.charAt(0)) || input.equals("0")) {
            System.out.println("The first parameter should be a natural number or zero.");
            state = "notDigit";
        } else {
            state = "start";
        }

        switch (state) {
            case "notDigit":
                promptEnterRequest(scanner);
                break;
            case "start":
                handleInput(scanner, ints);
                break;
        }
    }

    private static void handleInput(Scanner scanner,String[] ints) {

        int numberLength = 0;

        if (ints.length == 1) {
            numberLength = 1;
        } else if (ints.length == 2) {
            numberLength = 2;
        } else if (ints.length == 3) {
            numberLength = 3;
        } else if (ints.length == 4) {
            numberLength = 4;
        }

        long number = Long.parseLong(ints[0]);

        switch (numberLength) {

            case 1:
                if (number <= -1) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    promptEnterRequest(scanner);
                    return;
                } else if (number >= 1) {
                    checkPropertiesOneNumber(scanner, number);
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
                String firstProperty = number3.toLowerCase();
                returnPairOfProperties(number, ints);
              //  checkFirstProperty(ints, scanner, firstProperty);
                break;

            case 4:
                String number4 = ints[3];
                String secondProperty = number4.toLowerCase();
                findErrors(ints, scanner, secondProperty, number4);
                break;
        }
    }

    private static void processTwoInts(String[] ints, Scanner scanner) {
        String numberOne = ints[0];
        String numberTwo = ints[1];
        long number1 = Long.parseLong(numberOne);
        int indexTwo = Integer.parseInt(numberTwo);

        for (int i = 0; i < indexTwo; i++) {
            long number = number1++;

            System.out.print(number + " is ");
            System.out.print((checkForEven(number)) ? "even" : "odd");
            System.out.print((checkForBuzz(number)) ? ", buzz" : "");
            System.out.print((checkForDuck(number)) ? ", duck" : "");
            System.out.print((checkForPalindromic(number)) ? ", palindromic" : "");
            System.out.print((checkForGapfulTwoNumber(number)) ? ", gapful" : "");
            System.out.print((checkForSpy(number)) ? ", spy" : "");
            System.out.print((checkForSquare(number)) ? ", square" : "");
            System.out.print((checkForSunny(number)) ? ", sunny" : "");
            System.out.println();
        }
        promptEnterRequest(scanner);
    }

    private static void filterByEven(String[] ints, Scanner scanner) {

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
    }


    private static void filterByOdd(String[] ints, Scanner scanner) {

        String numberOne = ints[0];
        long number = Long.parseLong(numberOne);
        int numberTwo = Integer.parseInt(ints[1]);
        int counter = 0;

        while (counter != numberTwo) {
            if (checkForOdd(number)) {
               // printByChosenProperties(number);
             //   System.out.println(number + " odd");
                printByFirstProperty(number);
                counter++;
                number++;
            } else if (!checkForOdd(number)) {
                number += 1;
            }
        }
    }

   private static void filterByBuzz(String[] ints, Scanner scanner) {

        String numberOne = ints[0];
        long number = Long.parseLong(numberOne);
        int numberTwo = Integer.parseInt(ints[1]);
        int counter = 0;

        while (counter != numberTwo) {
            if (checkForBuzz(number)) {
            //    printByChosenProperties(number);
         //       System.out.println(number + " buzz");
                printBySecondProperty(number);
                counter++;
                number++;

            } else if (!checkForBuzz(number)) {
                number += 1;
            }
        }
    }

    private static void filterByDuck(String[] ints, Scanner scanner) {

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
    }

    private static void filterByPalindromic(String[] ints, Scanner scanner) {

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
    }

    private static void filterByGapful(String[] ints, Scanner scanner) {

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
    }

    private static void filterBySpy(String[] ints, Scanner scanner) {

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
    }

    private static void filterBySquare(String[] ints, Scanner scanner) {
        String numberOne = ints[0];
        long number = Long.parseLong(numberOne);
        int numberTwo = Integer.parseInt(ints[1]);
        int counter = 0;

        while (counter != numberTwo) {
            if (checkForSquare(number)) {
                printByChosenProperties(number);
                counter++;
                number++;
            } else if (!checkForSquare(number)) {
                number += 1;
            }
        }
    }

    private static void filterBySunny(String[] ints, Scanner scanner) {
        String numberOne = ints[0];
        long number = Long.parseLong(numberOne);
        int numberTwo = Integer.parseInt(ints[1]);
        int counter = 0;

        while (counter != numberTwo) {
            if (checkForSunny(number)) {
                printByChosenProperties(number);
                counter++;
                number++;
            } else if (!checkForSunny(number)) {
                number += 1;
            }
        }
    }



    private static String checkFirstProperty(String[] ints, Scanner scanner, String firstProperty) {

        switch (firstProperty) {

            case "even":
                filterByEven(ints, scanner);
              //  promptEnterRequest(scanner);
                break;
            case "odd":
                filterByOdd(ints, scanner);
               // promptEnterRequest(scanner);
                break;
            case "buzz":
                filterByBuzz(ints, scanner);
                promptEnterRequest(scanner);
                break;
            case "palindromic":
                filterByPalindromic(ints, scanner);
                promptEnterRequest(scanner);
                break;
            case "sunny":
                filterBySunny(ints, scanner);
                promptEnterRequest(scanner);
                break;
            case "spy":
                filterBySpy(ints, scanner);
                promptEnterRequest(scanner);
                break;
            case "square":
                filterBySquare(ints, scanner);
                promptEnterRequest(scanner);
                break;
            case "gapful":
                filterByGapful(ints, scanner);
                promptEnterRequest(scanner);
                break;
            case "duck":
                filterByDuck(ints, scanner);
                promptEnterRequest(scanner);
                break;
            default:
                System.out.println("The property " + firstProperty.toUpperCase() + " is wrong.");
                System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, " +
                        "GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE]");

                promptEnterRequest(scanner);
        }

        return ints[0];
    }

    private static void findErrors(String[]ints, Scanner scanner, String secondProperty, String number4) {

        String number3 = ints[2];
        String firstProperty = number3.toLowerCase();

        if(firstProperty.equals("even") && secondProperty.equals("odd")
                || firstProperty.equals("odd") && secondProperty.equals("even")) {

        System.out.println("The request contains mutually exclusive properties: " + number3 + " " + number4);
        System.out.println("There are no numbers with these properties.");
        promptEnterRequest(scanner);
        return;

    } else if(firstProperty.equals("duck") && secondProperty.equals("spy")
                || firstProperty.equals("spy") && secondProperty.equals("duck")) {
        System.out.println("The request contains mutually exclusive properties: " + number3 + " " + number4);
        System.out.println("There are no numbers with these properties.");
        promptEnterRequest(scanner);
        return;

    } else if(firstProperty.equals("sunny") && secondProperty.equals("square")
                || firstProperty.equals("square") && secondProperty.equals("sunny")) {

        System.out.println("The request contains mutually exclusive properties: " + number3 + " " + number4);
        System.out.println("There are no numbers with these properties.");
        promptEnterRequest(scanner);
        return;
    }

    String secondWord = "";
        if(!firstProperty.equals("even")&&!firstProperty.equals("odd")&&!firstProperty.equals("buzz")
                &&!firstProperty.equals("duck")&&!firstProperty.equals("palindromic")
                &&!firstProperty.equals("gapful")&&!firstProperty.equals("spy")
                &&!firstProperty.equals("square")&&!firstProperty.equals("sunny")
                &&!secondProperty.equals("even")
                &&!secondProperty.equals("odd")&&!secondProperty.equals("buzz")
                &&!secondProperty.equals("duck")&&!secondProperty.equals("palindromic")
                &&!secondProperty.equals("gapful")&&!secondProperty.equals("spy")
                &&!secondProperty.equals("square")&&!secondProperty.equals("sunny")) {

        secondWord = "both";

    } else if(!secondProperty.equals("even")&&!secondProperty.equals("odd")&&!secondProperty.equals("buzz")
            &&!secondProperty.equals("duck")&&!secondProperty.equals("palindromic")
            &&!secondProperty.equals("gapful")&&!secondProperty.equals("spy")
            &&!secondProperty.equals("square")&&!secondProperty.equals("sunny")) {

        secondWord = "second";

    }
        switch(secondWord) {
        case "second":
            System.out.println("The property " + secondProperty.toUpperCase() + " is wrong.");
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, " +
                    "GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE]");
            promptEnterRequest(scanner);
            break;
        case "both":
            System.out.println("The properties " + firstProperty.toUpperCase() + " " + secondProperty.toUpperCase() + " are wrong.");
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, " +
                    "GAPFUL, SPY, EVEN, ODD, SUNNY, SQUARE]");
            promptEnterRequest(scanner);
            break;

        default:
          //  returnPairOfProperties(ints, scanner, firstProperty, secondProperty);
            checkFirstProperty(ints, scanner, firstProperty);
            checkSecondProperty(ints, scanner, firstProperty, secondProperty);
            break;

        }
}

    private static void checkSecondProperty(String[]ints, Scanner scanner, String firstProperty, String secondProperty) {

        switch (secondProperty) {
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
            case "square":
                filterBySquare(ints, scanner);
                break;
            case "sunny":
                filterBySunny(ints, scanner);
                break;
        }
        long number = Long.parseLong(ints[0]);
        //returnPairOfProperties(number, ints);
    }

    private static String printByChosenProperties(long number) {

        String number1 = String.valueOf(number);

        System.out.print(number + " is ");
        System.out.print((checkForEven(number)) ? "even, " : "");
        System.out.print((checkForOdd(number)) ? "odd, " : "");
        System.out.print((checkForBuzz(number)) ? "buzz, " : "");
        System.out.print((checkForDuck(number)) ? "duck, " : "");
        System.out.print((checkForPalindromic(number)) ? "palindromic, " : "");
        System.out.print((checkForGapfulOneNumber(number)) ? "gapful, " : "");
        System.out.print((checkForSpy(number)) ? "spy, " : "");
        System.out.print((checkForSquare(number)) ? "square, " : "");
        System.out.print((checkForSunny(number)) ? "sunny, " : "");
        System.out.println();

        return number1;
    }

    private static long printByFirstProperty(long number) {

     //   String number1 = String.valueOf(number);

        System.out.print(number + " is ");
        System.out.print((checkForEven(number)) ? "even, " : "");
        System.out.print((checkForOdd(number)) ? "odd, " : "");
        System.out.print((checkForBuzz(number)) ? "buzz, " : "");
        System.out.print((checkForDuck(number)) ? "duck, " : "");
        System.out.print((checkForPalindromic(number)) ? "palindromic, " : "");
        System.out.print((checkForGapfulOneNumber(number)) ? "gapful, " : "");
        System.out.print((checkForSpy(number)) ? "spy, " : "");
        System.out.print((checkForSquare(number)) ? "square, " : "");
        System.out.print((checkForSunny(number)) ? "sunny, " : "");
        System.out.println();

        //return number1;
        return number;
    }

    private static long printBySecondProperty(long number) {

      //  String number2 = String.valueOf(number);

        System.out.print(number + " is ");
        System.out.print((checkForEven(number)) ? "even, " : "");
        System.out.print((checkForOdd(number)) ? "odd, " : "");
        System.out.print((checkForBuzz(number)) ? "buzz, " : "");
        System.out.print((checkForDuck(number)) ? "duck, " : "");
        System.out.print((checkForPalindromic(number)) ? "palindromic, " : "");
        System.out.print((checkForGapfulOneNumber(number)) ? "gapful, " : "");
        System.out.print((checkForSpy(number)) ? "spy, " : "");
        System.out.print((checkForSquare(number)) ? "square, " : "");
        System.out.print((checkForSunny(number)) ? "sunny, " : "");
        System.out.println();
      //  return number2;
        return number;
    }

    private static void returnPairOfProperties (long number, String[] ints) {
        // 1 3 odd buzz

        int counter = 0;
        int numberTwo = Integer.parseInt(ints[1]);

        String result = "";

        StringBuilder str = new StringBuilder(result);

        long fn1 = printByFirstProperty(number);
        long fn2 = printBySecondProperty(number);

        while (counter < numberTwo) {
            if (fn1 < fn2) {
                fn1 = printByFirstProperty(number);

            } else if (fn1 > fn2) {
                fn2 = printBySecondProperty(number);
            } else {
                str.append(fn1);
                counter++;
                printByFirstProperty(number);
                printBySecondProperty(number);
            }
        }
        System.out.println(str + " STR");
        System.out.println(counter + " COUNT");
    }


    private static boolean checkForSunny (long number) {

        boolean isSunny;
        double newNum = Math.sqrt(number + 1);
        int result = (int) newNum;

        if ( Math.pow (result, 2) == (number + 1)) {
            isSunny = true;
        } else {
            isSunny = false;
        }
        return isSunny;
    }

    private static boolean checkForSquare (long number) {

        boolean isSquare;
        double newNum = Math.sqrt(number);
        int result = (int) newNum;

        if (number == 1) {
            return true;
        } else if ( Math.pow (result, 2) == number) {
            isSquare = true;
        } else {
            isSquare = false;
        }
        return isSquare;
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
            countMultiplication *= Integer.parseInt(String.valueOf(numberOne.charAt(i)));

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
        System.out.println("square: " + checkForSquare(number));
        System.out.println("sunny: " + checkForSunny(number));

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
                reverseStr += str.charAt(i);
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