import java.util.Arrays;
import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder str = new StringBuilder(String.valueOf(strings));

        str.setCharAt();
        String stringNew = Arrays.toString(strings);

        String replaced = stringNew.replaceAll("[0-9]","");

        System.out.println(stringNew + " new");
        System.out.println(replaced + " rep");

        String output = replaced.replace(",");
        System.out.println(Arrays.asList(strings + " 5"));
        return replaced;

       /* String stringNew = str.toString();
        System.out.println(stringNew + " 1");

        String digits = "1234567890";
        char ch;

        for (int j = 0; j < digits.length(); j++) {
           ch = digits.charAt(j);
            for(int i = 0; i < stringNew.length(); i++) {
                str.append(i);
                if (stringNew.charAt(i) == ch) {
                    str.append(i + 1);
                }
            }
        }
        System.out.println(stringNew + " 2");
        System.out.println("dig " + str);

        */
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}