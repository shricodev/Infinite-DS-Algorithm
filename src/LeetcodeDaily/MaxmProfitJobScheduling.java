package LeetcodeDaily;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

class Job {
    int startTime;
    int endTime;
    int profit;
    public Job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}


// hard
public class MaxmProfitJobScheduling {
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();

        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        // sorting the list on the basis of endtime.
        Collections.sort(jobs, (x, y) -> x.endTime - y.endTime);
        // tree map is the life saver here.
        //      time,    profitTillTime
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        tmap.put(0, 0);
        int ans = 0;
        for (Job curr : jobs) {
            int lastEntryTillStart = tmap.floorKey(curr.startTime);
            int maxProfitTillStart = tmap.get(lastEntryTillStart);
            ans = Math.max(ans, maxProfitTillStart + curr.profit);
            tmap.put(curr.endTime, ans);
        }

        return ans;
    }
}
