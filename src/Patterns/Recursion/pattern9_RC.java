package Patterns.Recursion;

public class pattern9_RC {
    public static void main(String[] args) {
        int n = 5;
        int row = n;
        draw(0, 2 * row - 1, row);
    }

    static void draw(int sp, int star, int row) {

        if (star < 1) {
            return;
        }

        for (int i = 0; i < sp; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < star; i++) {
            System.out.print("*");
        }

        System.out.println();
        row--;
        draw(sp + 1, 2 * row - 1, row);
    }
}
