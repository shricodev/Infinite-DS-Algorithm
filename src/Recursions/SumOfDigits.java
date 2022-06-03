package Recursions;
public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(34123456));
    }

    static int sumOfDigits(int n) {

        // this is the base case.
        if (n <= 1) {
            return n;
        }

        // first we take the remainder to get the last digit.
        int remainder = n % 10;
        // then we divide the number by ten to remove the last digit.
        n = n / 10;

        return remainder + sumOfDigits(n);
    }
}
