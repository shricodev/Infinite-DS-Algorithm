package Patterns.Iterations.Numbers;

public class pattern27 {
    public static void main(String[] args) {
        draw(4);
    }

    /*
    1 2 3 4  17 18 19 20
      5 6 7  14 15 16
        8 9  12 13
          10 11
     */
    static void draw(int n) {

        int startNoLeft = 1;
        int startNoRight = 17;

        
        for (int row = 1; row <= n; row++) {

            int temp = startNoRight;

            for (int sp = 1; sp < row; sp++) {
                System.out.print("  ");
            }

            for (int col = row; col <= n; col++) {
                System.out.print(startNoLeft + " ");
                startNoLeft++;
            }

            if (row != n) {
                System.out.print(" ");
            }

            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print(startNoRight + " ");
                startNoRight++;
            }

            startNoRight = temp - (n - row);
            System.out.println();
        }
    }
}
