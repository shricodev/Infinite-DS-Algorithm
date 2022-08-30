package DynamicProgramming.Grids;

import java.util.Arrays;

public class NinjasTraining {

    public static void main(String[] args) {
        int[][] arr = {
            {10, 50, 1},
            {5, 100, 11},
        };


        int[][] dp = new int[arr.length][4];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        System.out.println(ninjaTrainRec(0, arr.length, -1, arr));
        // last task is given the three as it indicates that no task was done.
        // so if any other index was given then the ans may change on the edge cases 
        // so created a dp array of size 4 to make it stable.
        System.out.println(ninjaTrainMemo(0, arr.length, 3, arr, dp));
        System.out.println(ninjaTrainTabu(arr, dp));
        System.out.println(ninjaTrainNoSp(arr.length, arr));
    }

    static int ninjaTrainRec(int day, int n, int lastTask, int[][] points) {

        if (day == n) {
            return 0;
        }

        int maxAns = 0;
        for (int currTask = 0; currTask < 3; currTask++) {

            if (currTask != lastTask) {
                int point = points[day][currTask] + ninjaTrainRec(day + 1, n, currTask, points);
                maxAns = Math.max(maxAns, point);
            }
        }
        return maxAns;
    }

    // time complexity: O(N * 4) * 3
    // space complexity: O(N) + O(N * 4)
    static int ninjaTrainMemo(int day, int n, int lastTask, int[][] points, int[][] dp) {

        if (day == n) {
            return 0;
        }

        if (dp[day][lastTask] != -1) return dp[day][lastTask];

        int maxAns = 0;
        for (int currTask = 0; currTask < 3; currTask++) {
            
            if (currTask != lastTask) {
                int point = points[day][currTask] + ninjaTrainRec(day + 1, n, currTask, points);
                maxAns = Math.max(maxAns, point);
            }
        }
        return dp[day][lastTask] = maxAns;
    }

    // time complexity: O(N*4*3)
    // space complexity: O(N * 4)
    static int ninjaTrainTabu(int[][] points, int[][] dp) {
        // these are the base cases 
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        // these two lines take care of when the points array is only of row 1.
        dp[0][3] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(dp[0][3], points[0][2]);

        if (points.length == 1) return dp[0][3];
        
        
        for (int day = 1; day < points.length; day++) {
            
            for (int last = 0; last < 4; last++) {

                dp[day][last] = 0;

                for (int task = 0; task < 3; task++) {

                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                    
                }
                
            }
        }

        return dp[points.length - 1][3];

    }


    // time complexity: O(N*4*3)
    // space complexity: O(1)
    static int ninjaTrainNoSp(int n, int[][] points) {
        
        
        int prev[] = new int[4];
        
        // just storing the required one row.
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        
        for (int day = 1; day < n; day++) {

            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        // since the prev data is in the prev so taking the data from the array.
                        int maxVal = points[day][task] + prev[task];
                        temp[last] = Math.max(temp[last], maxVal);
                    }
                }
            }

            // since for the next iteration we need to use the latest value so assigning the dp to the
            // temp array.
            prev = temp;

        }

        return prev[3];
    }

}