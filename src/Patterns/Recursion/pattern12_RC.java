package Patterns.Recursion;

public class pattern12_RC {
    public static void main(String[] args) {
        int n = 5;
        draw(0, n);
    }

    static void draw(int sp, int star) {

        if (star < 1) {
            return;
        }

        for (int i = 0; i < sp; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < star; i++) {
            System.out.print("* ");
        }
        System.out.println();

        // recursive call.
        draw(sp + 1, star - 1);

        for (int i = 0; i < sp; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < star; i++) {
            System.out.print("* ");
        }
        
        System.out.println();

    }
}
