package week9;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutations {

    @Test
    public void test(){
        int[] nums ={1,2,3};
        System.out.println(printPermutations(nums));
    }

    public List<List<Integer>> printPermutations(int[] nums){
        List<List<Integer>> list= new ArrayList<>();
        permutationHelper(0,nums, list);
        return list;
    }

    public void permutationHelper(int index, int[] nums, List<List<Integer>> list){
        // base case
        if(index==nums.length){  //{1,2,3} {1,3,2}
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i=0;i<nums.length;i++){
                temp.add(nums[i]);
            }
            list.add(new ArrayList<>(temp));
            return;
        }
        // recursive call
        for (int i =index;i<nums.length;i++){
            swap(index, i, nums);
            permutationHelper(index+1, nums, list);
            // below call is needed to undo the change from current recursive method
            swap(index, i, nums);
        }
    }

    public void swap(int left, int right, int[] nums){
        int temp= nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

}
