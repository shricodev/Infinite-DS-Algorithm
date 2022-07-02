package DataSructures.Arrays;

public class NoOfElemInArrayWithEvenDigits_LC {
    public static void main(String[] args) {   
        int[] arr = {26, 1, 987, 69, 36, 22, 24};
        System.out.println(findNoOfEven(arr));
    }

    static int findNoOfEven(int[] arr) {

        if (arr.length == 0) {
            return -1;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {

            // there is no need of this statement but if we are using out own function to check instead of the length
            // fxn then we might have to take the edge case so better to handle -ve nos.

            // if (arr[i] < 0) {
            //     arr[i] = arr[i] * -1;
            // }
                
            // (String.valueOf(arr[i])).length() will convert the item in str and get the index length. 
            if ((String.valueOf(arr[i])).length() % 2 == 0) {
                count += 1;
            } 

        }
        return count;
    }
}
