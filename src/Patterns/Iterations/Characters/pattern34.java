package Patterns.Iterations.Characters;

public class pattern34 {
    public static void main(String[] args) {
        draw("ABCDE");
    }

    /*
    E D C B A
    D C B A
    C B A
    B A
    A
     */
    static void draw(String word) {
        int length = word.length();

        for (int row = length, p = word.charAt(length - 1); row >= 1; row--, p--) {

            int reference = p;

            for (int col = 1; col <= row; col++) {
                System.out.print((char)reference-- + " ");
            }

            System.out.println();
        }
    }
}

