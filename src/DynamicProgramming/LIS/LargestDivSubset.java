package DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivSubset {
    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        int[] arr = {1,2,4,8};
        Arrays.sort(arr);
        int n = arr.length;
        ldsRec(arr, n, new ArrayList<>(), 1, 0,res);
        System.out.println(res);
    }

    static void ldsRec(int[] arr, int n, List<Integer> ans, int prev, int index, List<Integer> res) {

        if (ans.size() > res.size()) {
            res =  new ArrayList<>(ans);
        }

        for (int ind = index; ind < n; ind++) {
            if (arr[ind] % prev == 0) {
                ans.add(arr[ind]);
                ldsRec(arr, n, ans, arr[ind], ind + 1, res);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
