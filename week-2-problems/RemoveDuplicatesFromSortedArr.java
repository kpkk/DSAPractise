package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveDuplicatesFromSortedArr {

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 5;
        Assertions.assertEquals(5, removeDuplicates(nums, k));
    }

    public int removeDuplicates(int[] nums, int k){
        int left=0, right=1, count=1, index=1;
        while (right<nums.length){
            if(nums[left]==nums[right]) count++;
            if(nums[left]!=nums[right]) count=1;
            if(count<=2){
                nums[index++]=nums[right];
            }
            left++;
            right++;
        }
        return index;
    }
}
