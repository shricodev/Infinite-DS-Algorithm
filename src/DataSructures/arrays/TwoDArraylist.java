package DataSructures.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class TwoDArraylist {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();

        // initializing the arraylist. because we need to initialize each arraylist that comes inside the arraylist.
        for (int i = 0; i < 4; i++) {
            arrList.add(new ArrayList<>());
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // to use this methods we need to have a list in the index of i.
                // so if we do not initialize it will have null so the initialization is must
                // otherwise the code is going to throw and error.
                arrList.get(i).add(sc.nextInt());
            }
        }
        System.out.println(arrList);
        sc.close();
    }
}
