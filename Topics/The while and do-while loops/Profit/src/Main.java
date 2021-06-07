import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double m = scanner.nextDouble();
        double p = scanner.nextDouble();
        double k = scanner.nextDouble();
        int year = 0;
       
        if (m == k) {
            System.out.println(0);
            return;
        }
         
        while (k > m) {
            m = m + m * (p / 100);
            ++year;
        } 
        System.out.println(year);       
    }
}
