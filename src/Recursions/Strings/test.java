package Recursions.Strings;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        ArrayList<Integer> b = new ArrayList<>(a);
        System.out.println(a);
        System.out.println(b);
    }
}
