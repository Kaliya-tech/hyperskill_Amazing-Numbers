import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        while (scanner.hasNext()) {
            int n = scanner.nextInt(); 
            sum += n;
            if (n == 0) {
                
                System.out.println(sum); 
                break;
            } 
          //  System.out.println(sum); 
        }
    }
}
