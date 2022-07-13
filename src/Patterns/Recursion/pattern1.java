package Patterns.Recursion;

/**
 * pattern1
 */
public class pattern1 {

    public static void main(String[] args) {
        draw(5, 5);
    }

    static void draw(int n, int temp) {

        if (temp == 0) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }
        System.out.println();

        draw(n, temp -= 1);

    }
    
}