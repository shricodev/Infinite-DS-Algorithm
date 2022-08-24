package Patterns.Iterations.Characters;

/**
 * PULCHOWK
 */
public class PULCHOWK {

    public static void main(String[] args) {
        draw();
    }

    /*
    P
    Pu
    PuL
    PULC
    PuLcH
    PULCHO
    puLcHoW
    PULCHOWK
     */
    static void draw() {

        String word = "PULCHOWK";

        for (int i = 0; i < word.length(); i++) {

            for (int j = 0; j <= i; j++) {

                if (i % 2 == 1 && i != 1) {
                    System.out.print(word.substring(0, i + 1));
                    break;
                } else {
                    if (j % 2 != 0) {
                        String temp = word.charAt(j) + "";
                        if (i == word.length() - 2 && j == 0) {
                            System.out.print(temp.toLowerCase());
                        } else {
                            System.out.print(temp.toLowerCase());
                        }
                    } else {
                        // yo extra condition chai second last row ko 0th col ko exception handle ko
                        // lagi
                        if (i == word.length() - 2 && j == 0) {
                            String temp = word.charAt(j) + "";
                            System.out.print(temp.toLowerCase());
                        } else {
                            System.out.print(word.charAt(j));
                        }

                    }
                }

            }
            System.out.println();
        }
    }
}