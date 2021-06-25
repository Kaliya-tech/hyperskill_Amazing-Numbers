import java.util.Arrays;

class ArrayOperations {
    public static int[][][] createCube() {
        int[][][] arr = new int[3][3][3];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    arr[i][j][k] = count;
                 //   System.out.print(Arrays.toString(arr[i][j][k]) + " ");
                }
                count++;
                //System.out.print(Arrays.toString(arr[i][j]) + " ");
            }
        }
        return arr;
    }
}

