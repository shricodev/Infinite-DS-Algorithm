package Patterns.Iterations.Characters;

public class pattern33 {
    public static void main(String[] args) {
        draw(6);
    }

    /*
     * This is the incolplete code for the pattern no 33.
     * not able to find the relation between the character case and the row/col.
     */
    static void draw(int n) {

        int chara = 'a';

        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= row; col++) {
                System.out.print((char)chara + " ");
                chara++;
            }

            System.out.println();
        }
    }
}
