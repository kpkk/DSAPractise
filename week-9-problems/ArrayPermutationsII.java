package week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ArrayPermutationsII {

    @Test
    public void test() {
        int[] nums = {1, 1, 2};
        Assertions.assertEquals(Arrays.asList(Arrays.asList(1, 1, 2), Arrays.asList(1, 2, 1), Arrays.asList(2, 1, 1)), permuteUniqueWithSpace(nums));
    }

    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        Assertions.assertEquals(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2), Arrays.asList(2, 1, 3),Arrays.asList(2, 3, 1),Arrays.asList(3, 2, 1), Arrays.asList(3, 1, 2)), permuteUniqueWithSpace(nums));
    }

    @Test
    public void tes2() {
        int[] nums = {3,3,0,3};
       // Assertions.assertEquals(Arrays.asList(Arrays.asList(1, 1, 2), Arrays.asList(1, 2, 1), Arrays.asList(2, 1, 1)), permuteUnique(nums));
        System.out.println(permuteUniqueWithSpace(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums){
        Set<List<Integer>> ans = new HashSet<>();
        helper(0, nums, ans);
        return new ArrayList<>(ans);
    }

    public void helper(int index, int[] nums, Set<List<Integer>> ans){
        if(index==nums.length){
            ArrayList<Integer> ds = new ArrayList<>();
            for (int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i=index;i<nums.length;i++){
            swap(index, i, nums);
            helper(index+1, nums, ans);
            swap(index, i, nums);
        }
    }

    public void swap(int index, int i, int[] nums){
        int temp= nums[index];
        nums[index]=nums[i];
        nums[i]=temp;
    }


    public List<List<Integer>> permuteUniqueWithSpace(int[] nums){
        Set<List<Integer>> ans= new HashSet<>();
        boolean[] visited= new boolean[nums.length];
        ArrayList<Integer> ds = new ArrayList<>();
        recHelper(nums, ans, ds, visited);
        return new ArrayList<>(ans);
    }

    public void recHelper(int[] nums, Set<List<Integer>> ans, List<Integer> ds, boolean[] visited){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if(!visited[i]){
                ds.add(nums[i]);
                visited[i]=true;
                recHelper(nums, ans, ds, visited);
                visited[i]=false;
                ds.remove(ds.size()-1);
            }
        }
    }

}













