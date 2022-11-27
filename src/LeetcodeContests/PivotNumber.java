package LeetcodeContests;

public class PivotNumber {
    
    public int getSum(int n) {
        return (n * (n + 1)) / 2;
    }
    
    public int pivotInteger(int n) {
        int ans = -1;
        for(int i = 1; i <= n; i++) {
            int sumFirstX = getSum(i);
            int sumXToN = getSum(n) - getSum(i-1);
            
            if (sumFirstX == sumXToN) {
                return i;
            }
        }
        return ans;
    }
}
