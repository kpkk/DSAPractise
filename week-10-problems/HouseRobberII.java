package week10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HouseRobberII {

    @Test
    public void test(){
        int[] nums={1,2,3,1};
        Assertions.assertEquals(4, robHouses(nums));
    }

    public int robHouses(int[] nums){
        // create dp array
        int[] dp1= new int[nums.length];
        Arrays.fill(dp1, -1);
        int[] dp2= new int[nums.length];
        Arrays.fill(dp2, -1);
        int ans1 = recursion(nums, 0, nums.length - 2, dp1);
        int ans2 = recursion(nums, 1, nums.length - 1, dp2);// recursion(nums, nums.length) // no of houses // index at which house is located
        return Math.max(ans1, ans2);
    }

    public int recursion(int[] nums, int start, int end, int[] dp){
        if(end<start) return 0;
        //if(n<0) return 0;
        if(dp[end]!=-1) return dp[end];
        // rob
        int rob = nums[end] + recursion(nums, start, end - 2, dp);
        // not rob
        int notRob = recursion(nums, start, end - 1, dp);
        return dp[end]=Math.max(rob, notRob);
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
