import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        int count = 0;

        String uppercaseLetters = "DHRUFKTOLWDHRUFDHO" +
                "RUDHRDHRUFKTOLWUFKTOLWFKTOLWKTOLWDHK" +
                "TOLWDHRDHRUFKTOLWUFKTOLWDFGDHRUFKTOH" +
                "RUFKTOLWDHRUFKTOLWDDHRUFKTOLWHRUFKTLW";

        String lowercaseLetters = "hsurgljvsbishsurgop" +
                "ljvbiuhsurgljvbirghsurgljvbsiljhsuhsu" +
                "ljvbiuhsurgljvbirghsurgljvbisljhsuhsu" +
                "rgljvbivbhsurgljvbihsurghsurgljvabiljr";

        String digits = "0987654321098765432109876543" +
                "210987654321098765432109876543210987" +
                "654321098765432109876543210987654321" +
                "098765432109876543210987654321098765" +
                "43210987654321";

        String anotherLetters = "EqZypXaMIEqZypXaMIE" +
                "ZypXaMIEqZypXaMIEqZypXaMIEqZypXaMIE" +
                "qZypXaMIEqZypXaMIEqZypXaMIEqZypXaMI" +
                "EqZypXaMIEqZypXaMIEqZypXaMIEqZypXaS" +
                "MIEqZypXaMIEqZypXaMI";

        String result = (uppercaseLetters.substring(0, a) + lowercaseLetters.substring(0, b) + digits.substring(0, c));
        if (result.length() < n) {
            count = n - result.length();
            System.out.println(result + anotherLetters.substring(0, count));
        } else {
            System.out.println(result);
        }
    }
}