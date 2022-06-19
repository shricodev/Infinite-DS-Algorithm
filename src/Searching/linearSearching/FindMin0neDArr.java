package Searching.linearSearching;

public class FindMin0neDArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, -1, -2};
        System.out.println(minfinder(arr));
    }

    private static int minfinder(int[] arr) {

        if (arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        // suppose the min value is in the index 0.
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        
        return min;
    }
}
