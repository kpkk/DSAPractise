package week5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BubbleSort {

    @Test
    public void test(){
        int[] nums={5,1,4,3,2};
        Assertions.assertArrayEquals(new int[]{1,2,3,4,5}, bubbleSort(nums));
    }

    /**
     * Intution
     * Send the largest number to the extreme right in each itertion
     *
     * @param nums
     * @return
     */

    public int[] bubbleSort(int[] nums){

        for (int i=0;i<nums.length-1;i++){
            boolean swap= false;
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    int temp= nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    swap=true;
                }
            }
            if(!swap) break;
        }
        return nums;
    }
}
