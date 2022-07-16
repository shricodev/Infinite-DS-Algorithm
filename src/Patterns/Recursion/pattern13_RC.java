package Patterns.Recursion;

public class pattern13_RC {
    public static void main(String[] args) {
        int n = 5;
        draw(n - 1, 1, 1, n);
    }

    static void draw(int sp, int star, int row, int n) {

        if (sp < 0) {
            return;
        }

        for (int i = 0; i < sp; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < star; i++) {

            if (i == 0 || i == 2 * row - 2 || row == n) {
                System.out.print("*");

            } else {
                System.out.print(" ");
            }
        }

        System.out.println();

        draw(sp - 1, 2 * row + 1, row + 1, n);

    }
}
