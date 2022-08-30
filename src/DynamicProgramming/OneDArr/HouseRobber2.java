package DynamicProgramming.OneDArr;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 0 };
        
        //NOTE: we dont need to make the two differnet array just add the start and end fxn parameter.
        // the temp1 array is going to hold all tha array element except the first
        // index.
        int[] temp1 = new int[arr.length - 1];
        // the temp1 array is going to hold all tha array element except the last index.
        int[] temp2 = new int[arr.length - 1];

        // filling the elements.
        for (int i = 0; i < arr.length; i++) {

            if (i != 0)
                temp1[i - 1] = arr[i];

            if (i != arr.length - 1)
                temp2[i] = arr[i];
        }

        int first = maxSumTabuNoSp(temp1);
        int last = maxSumTabuNoSp(temp2);

        System.out.println(Math.min(first, last));
    }

    // the same logic as of max sum non adjacent one but just removing the first and last
    // index in two differnet fxn calls.
    static int maxSumTabuNoSp(int[] arr) {

        // this is the edge case, what if the array length is just 1
        if (arr.length == 1)
            return arr[0];

        int prev = arr[0];
        int prev2 = 0;

        for (int i = 1; i < arr.length; i++) {

            int pick = arr[i];

            // this is another edge case to handle.
            // is i > 1 then only we can run the dp[i - 2] or else it will throw a index out
            // of bounds error.
            if (i > 1)
                pick += prev2;

            int noPick = 0 + prev;

            int curr = Math.max(pick, noPick);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}
