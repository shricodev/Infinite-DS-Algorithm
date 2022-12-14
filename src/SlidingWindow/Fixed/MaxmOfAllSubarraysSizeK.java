// package SlidingWindow.Fixed;

// import java.util.ArrayList;

// class Solution {
//     // Function to find maximum of each subarray of size k.
//* NOT A WORKING CODE. */
//     static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
//         // Your code here
//         ArrayList<Integer> ans = new ArrayList<>();
//         int i = 0, j = 0;
//         int maxWindow = Integer.MIN_VALUE;
//         while (j < n) {
//             maxWindow = Math.max(maxWindow, arr[j]);

//             if (j - i + 1 == k) {
//                 ans.add(maxWindow);
                
//                 i++;
//             }
//             j++;
//         }

//         return ans;
//     }
// }