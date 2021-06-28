import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String size = scanner.nextLine();
        String array = scanner.nextLine();
        String nM = scanner.nextLine();

        isOccur(array, nM);
    }

    private static void isOccur(String array, String nM) {

        boolean isNeverOccur = false;

        String[] arr = array.split(" ");
        String[] symbols = nM.split(" ");

        String n = symbols[0];
        String m = symbols[1];

        if (arr.length == 2) {
            if (arr[0].equals(m) && arr[1].equals(n)) {
                System.out.println(false);
                return;
            } else if (arr[0].equals(n) && arr[1].equals(m)) {
                System.out.println(false);
                return;
            } else {
                System.out.println(true);
                return;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals(m) && arr[i - 1].equals(n)) {
                    isNeverOccur = false;
                    break;
                } else if (arr[i].equals(n) && arr[i - 1].equals(m)) {
                    isNeverOccur = false;
                    break;
                } else {
                    isNeverOccur = true;
                }
            }
        }
        System.out.println(isNeverOccur);
    }
}