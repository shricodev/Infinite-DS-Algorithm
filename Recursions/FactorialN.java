public class FactorialN {
    public static void main(String[] args) {
        System.out.println(fact(0));
    }

    // long to hold longer digits.s
    static long fact(int n) {

        // since if we get 0 as an input then we need to handle both the cases.
        if (n <= 1) {
            return n;
        }

        // we need to add the return keyword since the function expects  to return data type of long
        return n * fact(n-1);
    }
}
