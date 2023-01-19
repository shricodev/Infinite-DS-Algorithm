#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int subarraysDivByK(vector<int> &nums, int k) {
        int n = nums.size();
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum % k == 0)
                    ans++;
            }
            sum = 0;
        }
        return ans;
    }
};

// this soln was unthinkable for me. credit: codestorywithMIK
// Approach-3 (Time : O(n), Space : O(n))
/*
    Concept behind this method
    K

    a  b  c  d   e   f   g    h
    -----s1-------
    -----------------s2--------

    Lets say,
    s1%k = x
    s2%k = x
    s1 = k*n + x
    s2 = k*m + x
    subarraySum = s2-s1
                = k*(m-n)
                Which proves that the subarray is divisible by k
*/

class Solution {
  public:
    int subarraysDivByK(vector<int> &A, int K) {
        map<int, int> mp;
        // since the sum 0 has a remainder.
        mp[0] = 1;
        int cumSum = 0;
        int res = 0;

        for (int i : A) {
            cumSum += i;
            int rem = (cumSum % K + K) % K; // To avoid -ve remainders

            if (mp.count(rem))
                res += mp[rem];
            mp[rem]++;
        }
        return res;
    }
};