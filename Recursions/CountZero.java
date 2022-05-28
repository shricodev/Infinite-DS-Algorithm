public class CountZero {
    public static void main(String[] args) {
        
        // METHOD ONE
        // countZero(1023);
        // System.out.println(count);

        // METHOD TWO
        System.out.println(methodTwo(1020300, 0));


    }

    static int count = 0;

    static void countZero(int n) {

        // this does work as well.
        if (n == 0) {
            return;
        }

        // having leading zero can result in an error because it interprets them in different number system.
        // this is the base condition.
        // if (n % 10 == n && n != 0) {
        //     return;
        // }

        if (n % 10 == 0) {
            count += 1;
        }

        n = n / 10;
        countZero(n);
    }


    static int methodTwo(int n, int zerocount) {

        if (n == 0) {
            return zerocount;
        }

        if (n % 10 == 0) {
            return methodTwo(n / 10, zerocount + 1);
        } else {
            return methodTwo(n / 10, zerocount);
        }
    }
}
