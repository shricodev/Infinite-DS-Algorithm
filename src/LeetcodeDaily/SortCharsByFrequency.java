package LeetcodeDaily;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class SortCharsByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
    public static String frequencySort(String s) {
        
        if (s.length() <= 1) return s;

        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
                continue;
            }
            map.put(ch, map.get(ch) + 1);
        }

        List<Entry<Character, Integer>> nlist = new ArrayList<>(map.entrySet());
        nlist.sort(Entry.comparingByValue(Comparator.reverseOrder()));

        StringBuilder ans = new StringBuilder();
        
        for (int i = 0; i < nlist.size(); i++) {
            char ch = nlist.get(i).getKey();
            for (int j = 0; j < nlist.get(i).getValue(); j++) {
                ans.append(ch);
            }
        }

        return ans.toString();        
    }
}
