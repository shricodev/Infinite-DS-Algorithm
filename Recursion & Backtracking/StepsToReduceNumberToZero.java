public class StepsToReduceNumberToZero {
    public static void main(String[] args) {
        // initially the count variable  is set to zero.
        System.out.println(divider(8, 0));
    }

    static int divider(int n, int count) {

        // the question is asking how many times the number can be divided to get zero.
        // base case.
        if (n == 0) {
            // so if the number is zero then just return the count argument.
            return count;
        }

        // if even divide the  number by two
        if (n % 2 == 0) {
            return divider(n/2, count + 1);
        }

        // if the number is odd subtract one from it.
        return divider(n-1, count + 1);

    }
}
