import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int dir = new Scanner(System.in).nextInt();
        System.out.println(dir == 1 ? "move up"
            : dir == 2 ? "move down"
            : dir == 3 ? "move left"
            : dir == 4 ? "move right"
            : dir == 0 ? "do not move"
            : "error!");
    }
}
