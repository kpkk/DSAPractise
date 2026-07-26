package week5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InsertionSort {

    @Test
    public void test() {
        int[] nums = {5, 1, 4, 3, 2};
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, insertionSort(nums));
    }

    public int[] insertionSort(int[] nums){
        for (int i=1;i<nums.length;i++){
            for (int j=i;j>0;j--){
                if(nums[j]<nums[j-1]){
                    int temp= nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                }
            }
        }
        return nums;
    }

}
