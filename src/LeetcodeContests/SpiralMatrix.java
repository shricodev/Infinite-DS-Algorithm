package LeetcodeContests;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;

        int startRow = 0;
        int startCol = 0;
        int endRow = row - 1;
        int endCol = col - 1;

        int count = 0;
        int total = row * col;

        List<Integer> ans = new ArrayList<>();

        while (count < total) {

            // traverse the right
            for (int i = startCol; i <= endCol && count < total; i++) {
                ans.add(matrix[startRow][i]);
                count++;
            }
            startRow++;

            // traverse the top to bottom
            for(int i = startRow; i <= endRow && count < total; i++) {
                ans.add(matrix[i][endCol]);
                count++;
            }
            endCol--;

            // traverse the bottom right to left.
            for (int i = endCol; i >= startCol && count < total; i--) {
                ans.add(matrix[endRow][i]);
                count++;
            }
            endRow--;

            // traverse the left most bottom to up.
            for (int i = endRow; i >= startRow && count < total; i--) {
                ans.add(matrix[i][startCol]);
                count++;
            }
        }
        return ans;
    }
}
