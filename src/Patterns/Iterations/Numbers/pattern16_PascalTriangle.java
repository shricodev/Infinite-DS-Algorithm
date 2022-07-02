package Patterns.Iterations.Numbers;

import java.util.ArrayList;
import java.util.List;

public class pattern16_PascalTriangle {
    public static void main(String[] args) {
        // System.out.println(pascalReturnArr(5));
        draw(5);
    }   
    
    static void draw(int n) {

        for (int row = 0; row < n; row++) {

            // for every row we are initializing the start of the printing number to 1.
            int number = 1;

            for (int sp = row; sp < n; sp++) {
                System.out.print(" ");
            }

            for (int col = 0; col <= row; col++) {

                System.out.print(number + " ");

                // this is the main formula for the code of pascal triangle.
                // use this when printing the pascal triangle in the console.
                number = number * (row - col) / (col + 1);
            }

            System.out.println();
        }
    }

    static List<List<Integer>> pascalReturnArr(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        // if the no of rows is 0 return empty list.
        if (numRows == 0) {
            return res;
        } 

        // we are addding the first row(list) in the result.
        res.add(new ArrayList<>());
        // adding the first element in the first row.
        res.get(0).add(1);
        
        // since we already have the first element in the result looping from 1 to numRows.
        for (int i = 1; i < numRows; i++) {
            // creating a new list for each row.
            List<Integer> currentRow = new ArrayList<>();
            // adding the first element in the first row.
            currentRow.add(1);
            
            // it is looping and adding the sum of element from previous indexes.
            for (int j = 1; j < i; j++) {
                currentRow.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }

            // adding the last element of the row.
            currentRow.add(1);
            res.add(currentRow);
        }
        return res;
    }

}

