import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class RemoveDuplicates {


    @Test
    public void test(){
        int[] nums={1,1,2};
        Assertions.assertEquals(2, removeDupsOptimised(nums));
    }

    @Test
    public void test1(){
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        Assertions.assertEquals(5, removeDupsOptimised(nums));
    }

    /**
     * initialise a hashset of type integer
     * iterate the array from start till the end index
     * keep adding the numbers to the hashset
     * given the set dedupes naturally , it will have unique numbers
     * return the set size
     * TC: O(n) SC: O(n)
     *
     */

    public int removeDuplicates(int[] nums){

        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        return set.size();
    }

    public int removeDupsOptimised(int[] nums){
        int left=0, right=1;
        while (right<nums.length){
            if(nums[left]!=nums[right]){
                left++;
                int temp=nums[right];
                nums[left]=nums[right];
                nums[right]=temp;
            }
            right++;
        }
        return left+1;
    }

}
