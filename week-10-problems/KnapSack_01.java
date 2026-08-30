package week10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class KnapSack_01 {

    @Test
    public void test(){
        int[] val={1,2,3};
        int[] wt={4,5,1};
        int W=4;
        Assertions.assertEquals(3, knapsack(val, wt, W));
    }

    // memoization -> recursive , Tabulation-> iterative

    public int knapsack(int[] val, int[] wt, int capacity){
        int[][] dp= new int[val.length][capacity+1];
        for (int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(val.length-1,val, wt, capacity, dp);
    }

    // n-> no of elements -> 0, 0
    // n -> last index -> n==0 (first element, at 0th index)
    public int helper(int n, int[] val, int [] wt, int capacity, int[][] dp){
        if(n==0){
            if(capacity>=wt[n]){ // knapsack capacity-2. wrt[0]- 1-2, then you can pick
                                 // knapsack capacity-2. wrt[0] >2, then you can't pick
                return val[n];
            }
            return 0;
        }
        // pick
        if(dp[n][capacity]!=-1) return dp[n][capacity];
        int pick=0;
        if(capacity>=wt[n])
            pick = val[n] + helper(n - 1, val, wt, capacity - wt[n], dp);

        // not pick
        int notPick= helper(n - 1, val, wt, capacity, dp);
        return dp[n][capacity]=Math.max(pick, notPick);
    }
}
