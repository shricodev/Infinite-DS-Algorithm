package Patterns.Iterations.Characters;

public class pattern32 {
    public static void main(String[] args) {
        draw("ABCDE");
    }
    
    /*
    E
    D E
    C D E
    B C D E
    A B C D E
     */
    static void draw(String word) {
        int length = word.length();

        for (int row = 1, p = word.charAt(length - 1); row <= length; row++, p--) {

            int reference = p;

            for (int col = 1; col <= row; col++) {
                System.out.print((char)reference++ + " ");
            }

            System.out.println();
        }
    }
}
