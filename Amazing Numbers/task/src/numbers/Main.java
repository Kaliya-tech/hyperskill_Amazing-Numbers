package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int num = scanner.nextInt();

        naturalOrNot(num);
    }

    private static void naturalOrNot (int num) {
        if (num < 1) {
            System.out.println("This number is not natural!");
            return;
        } else {
            oddOrEven(num);
        }
    }

    private static void oddOrEven (int num) {
        if (num % 2 == 0) {
            System.out.println("This number is Even.");
            checkNumber(num);
        } else {
            System.out.println("This number is Odd.");
            checkNumber(num);
        }
    }

    private static void checkNumber (int num) {
        //Buzz or not

        if (num % 10 != 7 && num % 7 != 0) {
            System.out.println("It is not a Buzz number.");
            System.out.println("Explanation:\n" +
                    num + " is neither divisible by 7 nor it ends with 7.");
        } else {
            System.out.println("It is a Buzz number.");
        }

        //Explanation
        int state = 0;

        if (num % 7 == 0 && num % 10 == 7) {
            state = 1;
        }else if (num % 7 == 0) {
            state = 2;
        } else if (num % 10 == 7) {
            state = 3;
        }

        switch (state) {
            case 1:
                System.out.println("Explanation:\n" +
                        num + " is divisible by 7 and it ends with 7.");
                break;
            case 2:
                System.out.println("Explanation:\n" +
                        num + " is divisible by 7.");
                break;
            case 3:
            System.out.println("Explanation:\n" +
                    num + " is ends with 7.");
            break;
        }
    }
}