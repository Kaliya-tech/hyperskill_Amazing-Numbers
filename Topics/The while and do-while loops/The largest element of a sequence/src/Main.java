import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        int max = 0;

        do {
            a = scanner.nextInt();
            max = (a > max) ? a : max;
        } while (a != 0);

        System.out.println(max);
    }    
}
