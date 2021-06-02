import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int atLeast = scanner.nextInt();
        int noMore = scanner.nextInt();
        int annSleeps = scanner.nextInt();

        if (annSleeps < atLeast) {
            System.out.println("Deficiency");
        } else if (annSleeps > noMore) {
            System.out.println("Excess");
        } else {
            System.out.println("Normal");
        }
    }
}