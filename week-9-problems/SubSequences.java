package week9;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SubSequences {

    @Test
    public void test(){
        int[] nums={1,2,3};
        System.out.println(generateSubSequences(nums));
    }

    public List<List<Integer>> generateSubSequences(int[] nums){
        List<List<Integer>> ans= new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        helper(0,nums,ans,list);
        return ans;
    }

    public void helper(int index, int[] nums, List<List<Integer>> ans, List<Integer> ds){
        // base case
        if(index==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        // pick
        ds.add(nums[index]);
        helper(index+1, nums, ans, ds);
        // non-pick
        ds.remove(ds.size()-1);
        helper(index+1, nums, ans, ds);
    }
}
