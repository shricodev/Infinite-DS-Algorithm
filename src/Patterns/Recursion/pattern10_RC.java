package Patterns.Recursion;

public class pattern10_RC {
    public static void main(String[] args) {
        int n = 5;
        // starting space and star.
        draw(n - 1, 1);
    }

    static void draw(int sp, int star) {
        
        // we cannot do sp == 0 since we wont print the last line becuz the base condn goes false.
        if (sp < 0) {
            return;
        }

        for (int i = 0; i < sp; i++) {
            System.out.print(" ");
        }

        for (int j = 0; j < star; j++) {
            System.out.print("* ");
        }

        System.out.println();

        draw(sp - 1, star + 1);

    }
}
