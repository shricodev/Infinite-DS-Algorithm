package LeetcodeDaily;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

class RandomizedSet {

    private Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (!set.contains(val)) {
            return false;
        }
        set.remove(val);
        return true;
    }
    
    public int getRandom() {
        // Integer[] nums = set.toArray(new Integer[set.size()]);
        // Random rndm = new Random();
        // int rndNo = rndm.nextInt(set.size());
        // return nums[rndNo];
        // OR, 
        Random rndm = new Random();
        List<Integer> nums = new ArrayList<>(set);
        return nums.get(rndm.nextInt(nums.size()));
    }
}
