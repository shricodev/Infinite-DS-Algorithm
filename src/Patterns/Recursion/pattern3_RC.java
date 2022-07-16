package Patterns.Recursion;

public class pattern3_RC {
    public static void main(String[] args) {
        draw(5);
    }

    static void draw(int n) {

        if (n == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();

        draw(n - 1);
    }
}
