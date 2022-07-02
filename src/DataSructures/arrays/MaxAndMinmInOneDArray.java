package DataSructures.Arrays;

public class MaxAndMinmInOneDArray {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 67, 89, 0, 12};

        maxmMinm(arr, 0);
        System.out.println(maxmVal);
        System.out.println(minmVal);
    }

    static int maxmVal = 0;
    static int minmVal = 0;

    static void maxmMinm(int[] arr, int index) {

        if (index == arr.length) {
            return;
        }

        if (arr[index] > maxmVal) {
            maxmVal = arr[index];
        }

        if (arr[index] < minmVal) {
            minmVal = arr[index];
        }

        maxmMinm(arr, index + 1);
    }
}
