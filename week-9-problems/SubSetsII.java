package week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class SubSetsII {

    @Test
    public void test(){
        int[] nums={1,2,2};
        Assertions.assertEquals(Arrays.asList(Arrays.asList(), Arrays.asList(1), Arrays.asList(1,2),Arrays.asList(1,2,2),Arrays.asList(2),Arrays.asList(2,2)),
                subSetsWithDup(nums));
    }

    @Test
    public void test1(){
        int[] nums={4,4,4,1,4};
        System.out.println(subSetsWithDup(nums));
    }

    public List<List<Integer>> subSetsWithDup(int[] nums){
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, ans, new ArrayList<>());
        return new ArrayList<>(ans);
    }

    public void helper(int index, int[] nums, List<List<Integer>> ans, List<Integer> ds){
        if(index>=0){
            ans.add(new ArrayList<>(ds));
        }
        for (int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            helper(i+1, nums, ans, ds);
            ds.removeLast();
        }
    }
}
