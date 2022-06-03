package Recursions;
public class NtoOne {
    public static void main(String[] args) {
        printer(30);
    }

    static void printer(int n) {

        if(n == 0) {
            return;
        }

        System.out.println(n);
        printer(n-1); // trusting the function: RECURSIVE LEAP OF FAITH. 
    }
}
