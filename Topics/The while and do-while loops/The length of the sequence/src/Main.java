import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        while (scanner.hasNext() == true) {
            int n = scanner.nextInt();
            counter++;
            if (n == 0) {
                System.out.println(counter - 1);
                break;
            }
        }
       // System.out.println(counter);
    }
}