package DataSructures.Queuess;

class Solution {
    // Function to find starting point where the truck can start to get through
    // the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[]) {
        // Your code here
        int n = petrol.length;
        int totalFuel = 0;
        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            totalCost += distance[i];
            totalFuel += petrol[i];
        }

        if (totalCost > totalFuel) return -1;
        
        int start = 0;
        int remainsGas = 0;

        for (int i = 0; i < n; i++) {
            remainsGas += petrol[i] - distance[i];
            if (remainsGas < 0) {
                start = i + 1;
                remainsGas = 0;
            }
        }
        return start;
    }
}
