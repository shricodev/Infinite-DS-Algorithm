package LeetcodeDaily;



import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlayerWithZeroOrOneLoss {

    public static void main(String[] args) {
        int[][] matches = { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 }, { 10, 4 },
                { 10, 9 } };
        System.out.println(findWinners(matches));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {

        //      player,  lose count
        TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();

        for (int[] is : matches) {
            int winner = is[0];
            int loser = is[1];
            tmap.putIfAbsent(winner, 0);
            if (!tmap.containsKey(loser)) {
                tmap.put(loser, 1);
            } else
                tmap.put(loser, tmap.get(loser) + 1);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ans.add(new ArrayList<>());
        }
        Set<Integer> set = tmap.keySet();
        for (int key : set) {
            if (tmap.get(key) == 0) {
                ans.get(0).add(key);
            } else if (tmap.get(key) == 1) {
                ans.get(1).add(key);
            }
        }

        return ans;
    }
}
