package LeetcodeContests;

class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {

        int[] ans = new int[queries.length];
        int ind = 0;
        for (int i = 0; i < queries.length; i++) {

            int pointx = queries[i][0];
            int pointy = queries[i][1];
            // length from the x to the lca of x and y.
            int xLen = 0;
            // length from the y to the lca of x and y.
            int yLen = 0;

            while (pointx != pointy) {
                if (pointx > pointy) {
                    xLen++;
                    pointx /= 2;
                } else {
                    yLen++;
                    pointy /= 2;
                }
            }
            // + 1 for the length added in the connection.
            ans[ind++] = xLen + yLen + 1;
        }
        return ans;
    }
}
