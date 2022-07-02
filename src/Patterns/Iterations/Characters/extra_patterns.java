package Patterns.Iterations.Characters;

public class extra_patterns {
    public static void main(String[] args) {
        // draw1(5);
        // draw2(6);
        // draw3(5);
        // draw4(4);
        // draw5(5);
        // draw6(5);
        // draw7("PIYUSH");
        // draw8("PIYUSH");
    }

    /*
    A 
    B B
    C C C
    D D D D
    E E E E E
    */
    static void draw1(int n) {

        for (int row = 1, p = 'A'; row <= n; row++, p++) {
            for (int col = 1; col <= row; col++) {
                System.out.print((char)p + " ");
            }
            System.out.println();
        }
    }

    /*
    F 
    E E
    D D D
    C C C C 
    B B B B B
    A A A A A A
     */
    static void draw2(int n) {
        

        for (int row = 1, p = 'F'; row <= n; row++, p--) {
            for (int col = 1; col <= row; col++) {
                System.out.print((char)p + " ");
            }
            System.out.println();
        }
    }
    
    /*
    A 
    C C
    E E E
    G G G G
    I I I I I
     */
    static void draw3(int n) {

        for (int row = 1, p = 'A'; row <= n; row++, p += 2) { // p += 2 will happen every other loop not the first one.
            for (int col = 1; col <= row; col++) {
                System.out.print((char)p + " ");
            }

            System.out.println();
        }
    }

    /*
    A 
    B B
    A A A
    B B B B
     */
    static void draw4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {

                if (row % 2 == 0) {
                    System.out.print('B' + " ");
                } else {
                    System.out.print('A' + " ");

                }

            }
            System.out.println();
        }
    }

    /*
    A
    A B
    A B C
    A B C D
    A B C D E
     */
    static void draw5(int n) {

        for (int row = 1; row <= n; row++) {
            for (int col = 1, p = 'A'; col <= row; col++, p++) {
                System.out.print((char)p + " ");
            }    
            System.out.println();
        }
    }

    /*
    E D C B A
      D C B A
        C B A
          B A
            A
     */
    // todo: this gives some different output in the console when debugging and different output when running.
    // not able to figure this out. but i understand the logic
    static void draw6(int n) {
        for (int row = 1, p = 'E'; row <= n; row++, p--) {

            int reference = p;

            for (int sp = 1; sp < row; sp++) {
                System.out.print(" ");
            }

            for (int col = row; col <= n; col++) {
                System.out.print((char)reference--);
            }
            System.out.println();
        }
    }


    /*
     * Pattern with specific word.

    P 
    I I
    Y Y Y
    U U U U
    S S S S S
    H H H H H H
     */

     static void draw7(String word) {
        int length = word.length();

        for (int row = 1, p = 0; row <= length; row++, p++) {
            
            for (int col = 1; col <= row; col++) {
                System.out.print(word.charAt(p) + " ");
            }

            System.out.println();
        }
     }


     /*
    P 
    P I
    P I Y
    P I Y U
    P I Y U S
    P I Y U S H
    */
     static void draw8(String word) {

        int length = word.length();

        for (int row = 1; row <= length; row++) {

            // this variable to keep track of the starting printing character in each row.
            int p = 0;

            for (int col = 1; col <= row; col++) {
                System.out.print(word.charAt(p++) + " ");
            }

            System.out.println();
        }

     }
}
