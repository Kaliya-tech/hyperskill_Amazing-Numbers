import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        int count = 0;
        String[] contain;

        if (input2.length() > 1 && !input1.contains(" ")) {
            contain = input1.split(" ");
        } else if (input1.contains(" ")) {
            contain = input1.split(" ");
        } else {
            contain = input1.split("");
        }

        for (int i = 0; i < contain.length; i++) {
            if (contain[i].contains(input2)) {
                count++;
            }
        }
        System.out.println(count);
    }
}