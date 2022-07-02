package DataSructures.Arrays;
import java.util.Arrays;

public class SwapTwoIndicesOneDArray {
    public static void main(String[] args) {
        int[] number = {1, 2, 3, 10, 13, 14};
        swap(number, 0, 1);

        System.out.println(Arrays.toString(number));
    }

    static void swap(int[] number, int indexOne, int indexTwo) {
        int temp = number[indexOne];
        number[indexOne] = number[indexTwo];
        number[indexTwo] = temp;
    }

}
