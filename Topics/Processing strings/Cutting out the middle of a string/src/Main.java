import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
       // String str = "";

        if (text.length() % 2 == 0) {
            System.out.print(text.substring(0, (text.length() / 2) - 1));
            System.out.print(text.substring((text.length() / 2) + 1, text.length()));
                        //HE-L-LO
        } else {
            System.out.print(text.substring(0, (text.length() / 2)));
            System.out.print(text.substring((text.length() / 2) + 1, text.length()));
        }
/*
        for (int i = 0; i < text.length(); i++) {
            str = str + text.charAt(i) + text.charAt(i);
        }
        System.out.println(str);

 */
    }
}