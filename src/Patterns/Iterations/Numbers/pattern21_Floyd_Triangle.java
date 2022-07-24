package Patterns.Iterations.Numbers;

public class pattern21_Floyd_Triangle {
    public static void main(String[] args) {
        draw(5);
    }
    
    /*
    1
    2  3
    4  5  6
    7  8  9  10
    11 12 13 14 15
     */
    static void draw(int n) {
        int startPrintNo = 1;

        for (int row = 1; row <= n; row++) {
            
            for (int col = 1; col <= row; col++) {
                System.out.print(startPrintNo + " ");
                startPrintNo++;
            }
            System.out.println();
        }
    }
}
