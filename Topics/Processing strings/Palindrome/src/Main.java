import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String reverseS = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            reverseS += s.charAt(i);
        }
        System.out.println(s.equals(reverseS) ? "yes" : "no");
    }
}