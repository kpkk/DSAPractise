package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxSumAubArray {

    @Test
    public void test() {
        int[] nums = {2, 3, -8, 7, -1, 2, 3};
        Assertions.assertEquals(11, maxSumSubArraykadane(nums));
    }

    @Test
    public void test1() {
        int[] nums = {2, 3, 4, 5};
        Assertions.assertEquals(14, maxSumSubArraykadane(nums));
    }

    public int maxSumSubArray(int[] nums) {
        int runningSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }

    public int maxSumSubArraykadane(int[] nums) {
       // int currSum = 0, maxSum = Integer.MIN_VALUE;
        int currSum=nums[0];
        int maxSum=nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(currSum+nums[i], nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int str1Hash = "FB".hashCode();
        int str2Hash = "Ea".hashCode();
        int n=32; //16
        int str1index= str1Hash & (n-1);
        int str2index= str2Hash & (n-1);
        System.out.println(str1Hash);
        System.out.println(str2Hash);
        System.out.println(str1index);
        System.out.println(str2index);
    }
}
