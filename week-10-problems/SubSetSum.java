package week10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubSetSum {

    @Test
    public void test(){
        int[] nums={3, 34, 4, 12, 5, 2};
        int target=9;
        Assertions.assertTrue(subSetSum(nums, target));
    }

    public boolean subSetSum(int[] nums, int target){
        Boolean[][] dp= new Boolean[nums.length+1][target+1]; //boolean
        return helper(nums, target, nums.length, dp);
    }

    public boolean helper(int[] nums, int target, int n, Boolean[][] dp){
        if(target==0) return true;
        if(n==0) return false; // t=2, nums[0]=2
        // pick
        boolean pick= false;
        if(dp[n][target]!=null) return dp[n][target];
        if(target>=nums[n-1])
            pick = helper(nums, target - nums[n-1], n - 1, dp);
        // not pick
        boolean notPick = helper(nums, target, n - 1, dp);
        return dp[n][target]=pick | notPick;
    }
}
