import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int army = scanner.nextInt();
        if ( army < 1){
            System.out.println("no army");
        }
        if (army <= 19 && army >= 1){
            System.out.println("pack");
        }
        if (army <= 249 && army >= 20){
            System.out.println("throng");
        }
        if (army <= 999 && army >= 250) {
            System.out.println("zounds");
        }
        if (army >= 1000)
            System.out.println("legion");
    }
}