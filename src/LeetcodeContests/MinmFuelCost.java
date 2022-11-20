package LeetcodeContests;

import java.util.ArrayList;
import java.util.List;

class Tuple {
    int node;
    int fuel;
    int seat;

    public Tuple(int node, int fuel, int seat) {
        this.node = node;
        this.fuel = fuel;
        this.seat = seat;
    }
}

public class MinmFuelCost {

    // couldn't code this, will upsolve.
    public long minimumFuelCost(int[][] roads, int seats) {

        // creating an adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < roads.length; i++) {
            int from = roads[i][0];
            int to = roads[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        // remain code.

        return 0; // added the return 0 to get rid of the fxn errors.

    }
}
