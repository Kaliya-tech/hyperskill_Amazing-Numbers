import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int count = 0;
        String result = "";

        String[] words = input.split(" ");

        for (String s : words) {
            if (count < s.length()) {
                count = s.length();
                result = s;
            }
        }
        System.out.print(result);
    }
}