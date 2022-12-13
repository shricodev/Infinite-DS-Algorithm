package LeetcodeDaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UniqueNoOfOccurence {
    
    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            if(!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        // we'll add the repetiton no to the set.
        Set<Integer> set = new HashSet<>();
        for (int i : map.keySet()) {
            // if already the repetition no is in the set then return false;
            if (set.contains(map.get(i))) {
                return false;
            }
            set.add(map.get(i));
        }
        return true;
    }
}
