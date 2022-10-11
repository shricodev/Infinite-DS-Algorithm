package DynamicProgramming.Partition;

public class ScrambleString {
    public static void main(String[] args) {
        String a = "great";
        String b = "rgeat";
        System.out.println(isScramble(a, b));
    }

    public static boolean isScramble(String a, String b) {

        if (a.length() != b.length())
            return false;

        if (a.length() == 0 && b.length() == 0)
            return true;

        return solve(a, b);
    }

    public static boolean solve(String a, String b) {

        if (a.compareTo(b) == 0)
            return true;

        if (a.length() <= 1)
            return false;

        int n = a.length(); // b.length() does not matter take any of these.
        boolean flag = false;

        for (int i = 1; i <= n - 1; i++) {

            // if any of the consition is true then return true, else the string is not scrambled.
            // condition one when the string are swapped.
            if (solve(a.substring(0, i), b.substring(n - i))
            &&
            solve(a.substring(i), b.substring(0, n - i))) {
                flag = true;
                break;
            }

            if (solve(a.substring(0, i), b.substring(0, i))
            && 
            solve(a.substring(i), b.substring(i))) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
