import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String the = "The";
        String the2 = the.toLowerCase();

        int count = 0;
        int count2 = 0;

        count = text.indexOf(the);
        count2 = text.indexOf(the2);

        if (count < 0) {
            System.out.println(count2);
        } else {
            System.out.println(count);
        }
    }
}