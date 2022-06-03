
package Recursions;public class SumNtoOne {
    public static void main(String[] args) {
        System.out.println(sumNToOne(10));
    }

    static int sumNToOne(int n) {

        // since if we get 0 as an input then we need to handle both the cases.
        if (n <= 1) {
            return n;
        }

        // we need to add the return keyword since the function expects  to return data type of long
        return n + sumNToOne(n - 1);
    }
}
