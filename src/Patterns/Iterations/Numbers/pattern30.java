package Patterns.Iterations.Numbers;

public class pattern30 {
    public static void main(String[] args) {
        draw(7);
    }

    /*
            1
          2 1 2
        3 2 1 2 3
      4 3 2 1 2 3 4
    5 4 3 2 1 2 3 4 5

    */

    static void draw(int n) {

        for (int row = 1; row <= n; row++) {
            
            for (int sp = row; sp < n; sp++) {
                System.out.print("  ");
            }

            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }

            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }

            System.out.println();

        }
    }


}
