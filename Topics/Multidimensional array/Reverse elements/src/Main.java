import java.util.Arrays;
import java.util.Scanner;

class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String row;
        String col;
        int [][] twoDimArray;

        row = scanner.nextLine();
        col = scanner.nextLine();
        int r; //= Integer.parseInt(row);
        int c;// = Integer.parseInt(col);

        for (int i = 0; i < row.length() - 1; i++) {
            r = row.charAt(i);
            for (int j = 0; j < col.length() - 1; j++) {
                c = col.charAt(j);
                twoDimArray = new int[r][c];
                System.out.println(twoDimArray[r][c] + " ");
            }
            System.out.println();
        }
     //   reverseElements(twoDimArray);

    }
    /*
    public static void reverseElements(int[][] twoDimArray) {
        for (int i = twoDimArray.length; i <= 0 ; i--) {
            for (int j = twoDimArray[i].length; j <= 0 ; j--) {
                System.out.println(twoDimArray[i][j] + " ");
            }
            System.out.println();
        }

    }


     */
}