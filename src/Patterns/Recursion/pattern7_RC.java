package Patterns.Recursion;

public class pattern7_RC {
    public static void main(String[] args) {
        int n = 5;
        // starting space and star
        draw(1, n);
    }

    static void draw(int sp, int star) {

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

        draw(sp + 1, star - 1);

    } 
}
