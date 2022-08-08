## TIPS TO SOLVE THE DP QUESTIONS (1D DP)

NOTE: write down the Recursive soln first then only the following tips apply.

### FOR MEMOIZATION
- Step 1 : create the dp DS for the index size.
- Step 2 : when returning the value, add that in the dp array or any ds.
- Step 3 : add a condition check when we see if the value has already been computed.

## FOR TABULATION (SC: O(N) -> ds size)

NOTE: to apply the tabulation technique, make sure that you have done the memoization.

- Step 1 : add the base case first in the code.
- Step 2 : run a loop till the index size and then compute the value but just in place of the recursion fxn call change that with the dp array. 
- Step 3 : add the required thing in the dp DS and outside the loop return the required value.

## TABULATION: Space optimized.

NOTE: if there is something like index - 1 or index - 2 in the soln, then there is always space optimization for sure. (CREDIT: Striver)

Just analyze the pattern from the tabulation technique and see if you can reduce the space complexity.


