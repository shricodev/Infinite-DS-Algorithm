package Patterns.Recursion;

public class pattern2_RC {
    public static void main(String[] args) {
        draw(5);
    }

    static void draw(int n) {

        if (n == 0) {
            return;
        }

        draw(n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
