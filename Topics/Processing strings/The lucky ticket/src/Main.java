import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();

        int result1 = text.charAt(0) + text.charAt(1) + text.charAt(2);
        int result2 = text.charAt(3) + text.charAt(4) + text.charAt(5);

        System.out.println(result1 == result2 ? "Lucky" : "Regular");

    }
}