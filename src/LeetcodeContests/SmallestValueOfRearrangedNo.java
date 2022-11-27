package LeetcodeContests;

import java.util.Arrays;
import java.util.Collections;

public class SmallestValueOfRearrangedNo {

    public static void main(String[] args) {
        System.out.println(smallestNumber(63));
    }

    public static long smallestNumber(long num) {
        String ans = "";
        String temp = Long.toString(num);
        if (num < 0) {
            // removing the - sign.
            temp = temp.replace("-", "");
        }
        int tempLen = temp.length();
        int countZero = 0;
        
        Integer[] arr = new Integer[tempLen];
        for(int i = 0; i < tempLen; i++) {
            if (temp.charAt(i) == '0') countZero++;
            arr[i] = temp.charAt(i) - '0';
        }

        // case when the no given is > 0
        if (num > 0) {
            Arrays.sort(arr);
            if (countZero != 0) {
                arr[0] = arr[countZero];
                arr[countZero] = 0;
            }
            for (int i = 0; i < arr.length; i++) {
                ans += arr[i];
            }
            return Long.parseLong(ans);
        }
        else {
            Arrays.sort(arr, Collections.reverseOrder());
            for (int i = 0; i < arr.length; i++) {
                ans += arr[i];
            }
        }
        return Long.parseLong(ans) * -1;
    }
}
