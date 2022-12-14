package SlidingWindow.Fixed;

import java.util.ArrayList;

public class MaxmSumSubarraySizeK{

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(100);
        arr.add(200);
        arr.add(300);
        arr.add(400);
        arr.add(50);
        arr.add(700);
        System.out.println(maximumSumSubarray(3, arr, 6));
    }

    static long maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
        // code here
        long maxSum = Integer.MIN_VALUE;
        long windowSum = 0;
        int i = 0; int j = 0;

        while (j < n) {
            
            windowSum += arr.get(j);

            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                // we remove the first element of the window.
                windowSum = windowSum - arr.get(i);
                // when the condn is satisfied then we shift the window.
                i++;
            }
            j++;
        }
        return maxSum;
    }
}
