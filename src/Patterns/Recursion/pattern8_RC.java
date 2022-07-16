package Patterns.Recursion;

public class pattern8_RC {
    public static void main(String[] args) {
        int n = 10;
        draw(n - 1, 1, 1);
    }

    static void draw(int sp, int star, int row) {

        if (sp < 0) {
            return;
        }

        for (int i = 0; i < sp; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < star; i++) {
            System.out.print("*");
        }

        System.out.println();

        draw(sp - 1, 2 * row + 1, row += 1);
    }
}
