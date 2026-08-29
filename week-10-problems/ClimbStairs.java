package week10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ClimbStairs {

    @Test
    public void test() {
        int n = 2;
        Assertions.assertEquals(2, climbStairs(n));
    }

    @Test
    public void test1() {
        int n = 4;
        Assertions.assertEquals(5, climbStairsTabulation(n));
    }

    // top down DP - memoization
    public int climbStairs(int n) {
        // dp array to store the states
        // since it's only the n (1 param) its enough to have 1-d array
        // dp[i] -> how many steps needed to climb i stairs
        int[] dp = new int[n + 1]; //4
        Arrays.fill(dp, -1); // {-1,-1,-1,-1}
        return helper(n, dp);
    }

    public int helper(int n, int[] dp) {
        if (n == 0 || n == 1) return 1;
        // if ans for specific sub problem is computed then simply return
        if (dp[n] != -1) return dp[n];
        int oneStep = helper(n - 1, dp);
        int twoStep = helper(n - 2, dp);
        dp[n] = oneStep + twoStep;
        return dp[n];
    }

    // iterative DP- Tabulation

    public int climbStairsTabulation(int n) {
        if(n==0||n==1) return 1;
        int[] dp = new int[n + 1]; //{1,1, 0,0,0}
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
