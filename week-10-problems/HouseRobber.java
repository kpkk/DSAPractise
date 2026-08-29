package week10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HouseRobber {

    @Test
    public void test(){
        int[] nums={1,2,3,1};
        Assertions.assertEquals(4, robHousesTabulation(nums));
    }

    public int robHouses(int[] nums){
        // create dp array
        int[] dp= new int[nums.length];
        Arrays.fill(dp, -1);
        return recursion(nums, nums.length-1, dp); // recursion(nums, nums.length) // no of houses // index at which house is located
    }

    public int recursion(int[] nums, int n, int[] dp){
        if(n==0) return nums[0];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        // rob
        int rob = nums[n] + recursion(nums, n - 2, dp);
        // not rob
        int notRob = recursion(nums, n - 1, dp);
        return dp[n]=Math.max(rob, notRob);
    }

    public int robHousesTabulation(int[] nums){
        int[] dp= new int[nums.length];
        dp[0]=nums[0];
        dp[1]= Math.max(nums[0], nums[1]); // {1,2} -> dp={1,2 }
        for (int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[nums.length-1];
    }
}
