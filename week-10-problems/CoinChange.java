package week10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import week5.MergeIntervals;

import java.util.Arrays;

public class CoinChange {

    @Test
    public void test(){
        int[] coins={1,2,5};
        int amount=11;
        Assertions.assertEquals(3, coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount){
        int[][]dp=new int[coins.length][amount+1];
        for (int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        int helper = helper(coins.length - 1, coins, amount,dp);
        return helper==Integer.MAX_VALUE?-1:helper;
    }
    public int helper(int n, int[] coins, int amount, int[][] dp){
        if(amount==0) return 0;
        if(n==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
            else return Integer.MAX_VALUE;
        }
        if(dp[n][amount]!=-1) return dp[n][amount];
        // pick
        int pick =Integer.MAX_VALUE;
        if(amount>=coins[n])
            pick = 1 + helper(n, coins, amount - coins[n], dp);
        // not pick
        int notPick = helper(n - 1, coins, amount, dp);

        return dp[n][amount]=Math.min(pick, notPick);
    }
}
