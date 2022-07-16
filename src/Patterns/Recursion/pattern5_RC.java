package Patterns.Recursion;

public class pattern5_RC {
    public static void main(String[] args) {
        int n = 10;
        drawUpperN(n);
        drawLowerNM1(n - 1);
    }

    static void drawUpperN(int n) {

        if (n == 0) {
            return;
        }

        drawUpperN(n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    static void drawLowerNM1(int n) {

        if (n == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();

        drawLowerNM1(n - 1);
    }
}
