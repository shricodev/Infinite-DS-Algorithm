public class FibonacciSeries {
    public static void main(String[] args) {
        int a = 0, b = 1;
        int n = 7;
        System.out.print(a + " ");
        System.out.print(b + " ");
        printFiboSeris(n - 2, a, b);        
    }

    static void printFiboSeris(int n, int secondlast, int last) {
        if (n == 0) {
            return;
        }

        int c = secondlast + last; // a + b
        System.out.print(c + " ");
        printFiboSeris(n-1, last, c);

        
    }
}
