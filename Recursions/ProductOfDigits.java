public class ProductOfDigits {
    public static void main(String[] args) {
        System.out.println(productOfDigits(1234));

    }

    static long productOfDigits(int n) {
        
        // this is the base case.
        if (n % 10 == n) {
            return n;
        }

        
        // first we take the remainder to get the last digit.
        int remainder = n % 10;
        // then we divide the number by ten to remove the last digit.
        n = n / 10;

        return remainder * productOfDigits(n);
    }
}
