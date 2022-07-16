package Patterns.Recursion;

public class pattern14_RC {
    public static void main(String[] args) {
        int n = 10;
        int row = n;
        draw(0, 2 * row - 1, row, n);
    }

    static void draw(int sp, int star, int row, int n) {

        if (star < 1) {
            return;
        }

        for (int i = 0; i < sp; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < star; i++) {
            if (i == 2 * row - 2 || i == 0 || row == n) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }

        System.out.println();
        row--;
        draw(sp + 1, 2 * row - 1, row, n);

    }
}
