package Patterns.Iterations.Characters;

public class pattern33 {
    public static void main(String[] args) {
        draw(6);
    }
    
    static void draw(int n) {

        int l = 1;
        int k = 0;

        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= row; col++, l++, k++) {

                if (k % 2 == 0) {
                    System.out.print((char) (l+96) + " ");
                } else {
                    System.out.print((char) (l + 64) + " ");
                }
            }

            System.out.println();
        }
    }
}
