package Patterns.Iterations.Numbers;

public class pattern31 {
    public static void main(String[] args) {
        draw(3);
    }

    /*
         4 4 4 4 4 4 4  
         4 3 3 3 3 3 4   
         4 3 2 2 2 3 4
         4 3 2 1 2 3 4   
         4 3 2 2 2 3 4   
         4 3 3 3 3 3 4   
         4 4 4 4 4 4 4  
     */
    static void  draw(int n) {
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                // left index from the wall is eq to column.
                int left = col;
                // up index from the wall is eq to row.
                int up = row;
                // right index from the wall is eq to n - col.
                int right = n - col;
                // down index from the wall is eq to n - row.
                int down = n - row;
                // the minimum of all these indices is the answer.
                // this will print from outer border 0
                int maxAmongAll = Math.max(Math.max(left, right), Math.max(up, down));
                // this willl print from outer border n
                // int maxAmongAll = Math.max(Math.max(left, right), Math.max(up, down));
                System.out.print(maxAmongAll + " ");  
                // System.out.print(maxAmongAll + " ");  
            }
            System.out.println();
            
        }
    }
}
