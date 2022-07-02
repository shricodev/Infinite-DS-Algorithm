package Patterns.Iterations.Stars;


public class pattern7 {

    public static void main(String[] args) {
        draw(5);
    }

    /**
    *****
     ****
      ***
       **
        *
    */
    static void draw(int n) {
        int space = 0;
        for (int row = 0; row <= n; row++) {

            for (int sp = 0; sp < space; sp++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= n - row; col++) {
                System.out.print("*");
            }
            space++;
            System.out.println();
        }
    }
    
}