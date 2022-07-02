package DataSructures.Arrays;
import java.util.Arrays;
import java.util.Scanner;

public class TwoDArray {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int arr[][] = new int[3][3]; // 3 -> row, 3 -> column

        int column = 3;

        // for individual rows.
        // arr.length gives the length of the rows.
        // FOR INPUT
        for(int row = 0; row < arr.length; row++) {
            // for columns.
            for(int col = 0; col < column; col++) {
                arr[row][col] = sc.nextInt();
            }
        }

        // FOR OUTPUT
        // i -> rows
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i])); // cuz every row is an individual array.
        }

        // FOR OUTPUT using for each
        // since everry element in the array itself is an array so the data type is array itself.
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }


        // when the column is not fixed in a array.

        int[][] array2 = {
            {1, 2, 3, 4, 5, 6},
            {7, 8 , 9},
            {10, 11, 12, 13}
        };

        // printing thh array.
        for (int i = 0; i < array2.length; i++) {
            // we are running the column loop less than the length of the array in the ith index.
            for (int col = 0; col < array2[i].length; col++) {
                System.out.print(array2[i][col] + " ");
            }
            System.out.println();
        }


        sc.close();

    }


}