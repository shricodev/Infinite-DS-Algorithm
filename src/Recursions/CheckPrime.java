package Recursions; 


public class CheckPrime {
    public static void main(String[] args) {
        // we take count from 2 because we have to take the value from 2 to n.
        System.out.println(checkPrimeNo(69, 2));
    }

    static boolean checkPrimeNo(int n, int count) {
        
        // base candition
        if (count == n) {
            return true;
        }

        if (n <= 1) {
            return false;
        }


        if (n % count == 0) {
            return false;
        }

        return checkPrimeNo(n, count + 1);
    }
}