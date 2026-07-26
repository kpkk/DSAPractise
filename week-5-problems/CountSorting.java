package week5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountSorting {
    @Test
    public void test() {
        int[] nums = {5, 1, 4, 3, 2};
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5000}, countSorting(nums));
    }

    public int[] countSorting(int[] nums){
        int max= Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            max=Math.max(max, nums[i]);
        }
        int[] freq= new int[max+1];
        // initialise the numbers
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        int index=0;
        for (int i=0;i<freq.length;i++){
            for(int j=0;j<freq[i];j++){
                nums[index++]=i;
            }
        }
        return nums;
    }

}
