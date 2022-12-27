// package SlidingWindow.Variable;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDiffIntegers {
    
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,4};
        int k = 3;
        // System.out.println(subarraysWithKDistinct(nums, k));
    }

    //* NOTE: this qn cannot be done using this approach of sliding window. Some modifications should be done here to make it workaable.
    // public static int subarraysWithKDistinct(int[] nums, int k) {
        
    //     int n = nums.length;
    //     int i = 0, j = 0;
    //     int countSubarrays = 0;
    //     Map<Integer, Integer> mp = new HashMap<>();
        
    //     while (j < n) {

    //         int num = nums[j];

    //         if (!mp.containsKey(num)) {
    //             mp.put(num, 1);
    //         } else {
    //             mp.put(num, mp.get(num) + 1);
    //         }
            
    //         if (mp.size() == k) {
    //             countSubarrays++;
    //         }
            
    //         if (mp.size() > k) {
                
    //             while (mp.size() > k) {
    //                 mp.put(nums[i], mp.get(nums[i]) - 1);
    //                 if (mp.get(nums[i]) == 0) {
    //                     mp.remove(nums[i]);
    //                 }
    //                 i++;
    //             }
    //         }
    //         j++;
    //     }
    //     return countSubarrays;
    // }
}
