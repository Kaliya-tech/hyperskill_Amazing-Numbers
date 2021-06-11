import java.util.Scanner;
//import java.math.BigInteger;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n1 = scanner.nextLong();
        String operation = scanner.next();
        long n2 = scanner.nextLong();

        
        switch (operation) {
            case "+":
                System.out.println(n1 + n2);
                break;
            case "-":
                System.out.println(n1 - n2);
                break;
            case "/":  
                if (n2 == 0) {
                    System.out.println("Division by 0! ");
                    break;
                } else {
                    System.out.println(n1 / n2);
                    break;
                }
            case "*":
                System.out.println(n1 * n2);
                break;
            default:
                System.out.println("Unknown operator");
        }

    }
}
