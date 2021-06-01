import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        String str = "";

        for (int i = 0; i < text.length(); i++) {
            str = str + text.charAt(i) + text.charAt(i);
        }
        System.out.println(str);
    }
}