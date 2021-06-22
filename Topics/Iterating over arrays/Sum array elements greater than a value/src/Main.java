import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    //    int  = scanner.nextInt();
       // short c = scanner.nextShort();
        String size = scanner.nextLine();
        String text = scanner.nextLine();
       // short cc = scanner.nextShort();
        int point = scanner.nextInt();

        String[] nums = text.split(" ");

        System.out.println(size);
        System.out.println(text);
      //  System.out.println(text2);
        System.out.println(Arrays.toString(nums));
        System.out.println(point + " point");
    }
}