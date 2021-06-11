import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String strings) {
        StringBuilder str = new StringBuilder(strings);

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                str.deleteCharAt(i--);
            } else if (str.charAt(i) == ' ') {
                str.deleteCharAt(i--);
            } else if (str.charAt(i) == ',') {
                str.deleteCharAt(i--);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strings = scanner.nextLine();
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}