package DynamicProgramming.OneDArr;

public class NoOfStepNStair {
    public static void main(String[] args) {
        System.out.println(noOfWays(10));
    }

    // this is the same approach as the fibonacci qn. STRIVER OP😎 
    // copy paste the fibonacci code.
    // link: https://leetcode.com/problems/climbing-stairs/
    static int noOfWays(int n) {
        // since we can jump from the 1st stair to 0th stair once and same for the 0th stair.
        int prev2 = 1;
        int prev = 1;
        int currentI = 0;
        
        for (int i = 2; i <= n; i++) {
            currentI = prev2 + prev;
            prev2 = prev;
            prev = currentI;
        }
        return prev;
    }
}
