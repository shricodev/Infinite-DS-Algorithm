public class TowerOfHanoi {
    public static void main(String[] args) {
        hanoi(3, 'A', 'B', 'C');
    }

    static void hanoi(int n, char source, char helper, char dest) {

        // base condition
        if (n == 1) {
            System.out.println("Moving " + n + " from " + source + " to " + dest);
            return;
        }

        // moving n-1 top element from source to helper with dest as a helper
        hanoi(n-1, source, dest, helper);
        
        // this is the print line to move the nth dallo to the destination
        System.out.println("Moving " + n + " from " + source + " to " + dest);

        // moving n-1 top element from helper to destination with source as a helper
        hanoi(n-1, helper, source, dest);

    }
}