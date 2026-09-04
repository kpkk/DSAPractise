package week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CombinationSum {

    /**
     * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
     * <p>
     * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
     * <p>
     * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: candidates = [2,3,6,7], target = 7
     * Output: [[2,2,3],[7]]
     * Explanation:
     * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
     * 7 is a candidate, and 7 = 7.
     * These are the only two combinations.
     * Example 2:
     * <p>
     * Input: candidates = [2,3,5], target = 8
     * Output: [[2,2,2,2],[2,3,3],[3,5]]
     * Example 3:
     * <p>
     * Input: candidates = [2], target = 1
     * Output: []
     */

    @Test
    public void test(){
        int[] nums={2,3,6,7};
        int target=7;
        Assertions.assertEquals(Arrays.asList(Arrays.asList(2,2,3), Arrays.asList(7)), combinationSumAlternateApproach(nums, target));
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> ans= new HashSet<>();
        helper(0, nums, target, ans, new ArrayList<Integer>());
        return new ArrayList<>(ans);
    }

    public void helper(int index, int[] nums, int target, Set<List<Integer>> ans, List<Integer> ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i=index;i<nums.length;i++){
            if(nums[i]<=target){
                ds.add(nums[i]);
                helper(i, nums, target-nums[i], ans, ds);
                ds.removeLast();
            }
            else {
                helper(i+1, nums, target, ans, ds);
            }
        }
    }

    public List<List<Integer>> combinationSumAlternateApproach(int[] nums, int target){
        List<List<Integer>> ans= new ArrayList<>();
        recursion(0, nums, target, ans, new ArrayList<>());
        return ans;
    }

    public void recursion(int index, int[] nums, int target, List<List<Integer>> ans, List<Integer>ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(target<0 || index>=nums.length)
            return;
        if(target>=nums[index]){
            ds.add(nums[index]);
            recursion(index, nums, target-nums[index], ans, ds);
            ds.removeLast();
        }
        recursion(index+1, nums, target, ans, ds);

    }
}
