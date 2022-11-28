package DataSructures.Stackzz;


public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = { 2, 3 };
        // System.out.println(findArea(heights));
    }

    // BRUTE APPROACH
    // dont know what is wrong with the code.
    // it does not pass all the test cases of any online judge.
    // time complexity; O(n^2)
    // static int findArea(int[] heights) {
    //     int n = heights.length;
    //     int maxi = 0;

    //     for (int i = 0; i < n; i++) {
    //         if (i < n - 1 && heights[i] != heights[i + 1]) {
    //             break;
    //         } else {
    //             if (i == n - 1) {
    //                 return heights[i] * n;
    //             }
    //         }
    //     }

    //     for (int i = 0; i < n; i++) {
    //         int leftSmallInd = i;
    //         int rightSmallInd = i;

    //         // for finding the left just smallest element.
    //         for (int j = i; j >= 0; j--) {
    //             if (heights[j] < heights[i]) {
    //                 // this is the boundary of the left smaller index that is the + 1.
    //                 leftSmallInd = j + 1;
    //                 break;
    //             }
    //         }

    //         // for finding the right just smallest element.
    //         for (int j = i; j < n; j++) {
    //             if (heights[j] < heights[i]) {
    //                 // this is the boundary of the right smaller index that is the - 1.
    //                 rightSmallInd = j - 1;
    //                 break;
    //             }
    //         }

    //         maxi = Math.max(maxi, (rightSmallInd - leftSmallInd + 1) * heights[i]);
    //     }

    //     return maxi;
    // }
}