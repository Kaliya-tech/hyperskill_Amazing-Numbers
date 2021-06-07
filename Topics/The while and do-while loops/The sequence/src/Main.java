import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int num = 0;
        int count = 0;
        int result = 0;
        int newRes = 0;
        int output = 0;

        for (int i = size; i > 0; i--) {
            count++;
            while (count > size) {
                num = scanner.nextInt();
                if (num % 4 == 0) {
                    result = num;
                }

                if (result > num) {
                    newRes = num;
                    if (newRes % 4 == 0) {
                        result = newRes;
                        output = result;
                    } else {
                        newRes = result;
                        output = newRes;
                    }
                 //   System.out.println(output);
                }

            }
        }
      //  System.out.println(result);
    }
}