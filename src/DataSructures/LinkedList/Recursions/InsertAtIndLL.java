package DataSructures.LinkedList.Recursions;

import java.util.LinkedList;

public class InsertAtIndLL {
    public static void main(String[] args) {
        
    }

    static LinkedList<Integer> insertRec(int index, int val) {




        return insertRec(index - 1, val);
    } 
} 