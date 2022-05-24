public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibo(50));
    }

    // use the long return type because for no bigger than 9-10 digits.
    static long fibo(int n) {

        // fibo of 1 and 0 is nothing but the number itself.
        if (n <= 1) {
            return n;
        }

        // fibo: recursive formula
        // this is a very ineffficiennt way to calculate fibonacci. This algorithm takes a hell lot of time for even no bigger than 45
        return fibo(n - 1) + fibo(n - 2);

    }
}
