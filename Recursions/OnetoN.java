public class OnetoN {
    public static void main(String[] args) {
        printer(7);
    }

    static void printer(int n) {

        if (n == 0) {
            return;
        }

        printer(n - 1); // trusting the function: RECURSIVE LEAP OF FAITH.
        System.out.println(n);
    }
}
