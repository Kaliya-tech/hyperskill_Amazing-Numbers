import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        
        int a1 = a / 1000;
        int a2 = (a / 100) % 10;
        int a3 = (a / 10) % 10;
        int a4 = a % 10;
        
        if (a1 == a4 && a2 == a3) {
            System.out.println("1");
        } else {
            System.out.println("37");
        }
    }    
}
