package Patterns.Iterations.Stars;

/*
         *
        * *
       * * *
      * * * *
     * * * * *
      * * * *
       * * *
        * *
         *
 */
public class pattern28_byKunal {

    public static void main(String[] args) {
        draw(5);
    }

    static void draw(int n) {
        for (int row = 0; row < 2 * n; row++) {
            
            int totalColsOfRow = row >= n ? 2 * n - row: row;
            int noOfSpaces = n - totalColsOfRow;

            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }

            for (int col = 0; col < totalColsOfRow; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}