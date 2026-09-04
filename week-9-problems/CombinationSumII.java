package week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CombinationSumII {

    @Test
    public void test(){
        int[] nums={10,1,2,7,6,1,5};
        int target=8;
        Assertions.assertEquals(Arrays.asList(Arrays.asList(1,1,6), Arrays.asList(1,2,5), Arrays.asList(1,7), Arrays.asList(2,6)),
                comSumII(nums, target));
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target){
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        rec(0, nums, target, ans, new ArrayList<>());
        return new ArrayList<>(ans);
    }

    public void rec(int index, int[] nums, int target, List<List<Integer>> ans, List<Integer> ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(index>=nums.length || target<nums[index])
            return;
        ds.add(nums[index]);
        rec(index+1, nums, target-nums[index], ans, ds);
        ds.removeLast();
        int next=index+1;
        while (next<nums.length && nums[next]== nums[index]){
            next++;
        }
        rec(next, nums, target, ans, ds);
    }

    public List<List<Integer>> comSumII(int[] nums, int target){
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, target, ans, new ArrayList<>());
        return ans;
    }

    public void helper(int index, int[] nums, int target, List<List<Integer>> ans, List<Integer> ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1])continue;
            if(nums[i]>target) break;
            ds.add(nums[i]);
            helper(i+1, nums, target-nums[i], ans, ds);
            ds.removeLast();
        }
    }


}
