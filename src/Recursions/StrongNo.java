package Recursions;

public class StrongNo {
    public static void main(String[] args) {
        // yesle chai sab factorial ko sum store hanxa.
        int sum = 0;
        int n = 145;
        // n ko starting value ko reference ko lagi.
        int temp = n;

        while (n > 0) {
            sum += fact(n % 10);
            n /= 10;
        }

        if (sum == temp) {
            System.out.println("Strong!");
        } else {
            System.out.println("Not Strong!");
        }
    }

    // yo tei factorial nikalne code ho.
    static int fact(int n) {
        if (n <= 1) return n;
        return n * fact(n - 1);
    }
}
