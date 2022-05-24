public class ReverseANumber {
    public static void main(String[] args) {
        reverseNumberWithPrint(2394727);
    }

    static void reverseNumberWithPrint(int n) {

        // for a single digit there is no sense in repeating. so this is the base case.
        if (n % 10 == n) {
            System.out.println(n);
            return;
        }

        int remainder = n % 10;
        n = n / 10;
        System.out.print(remainder);
        reverseNumberWithPrint(n);
         
    }
    
}
