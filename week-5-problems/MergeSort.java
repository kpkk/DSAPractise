package week5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    @Test
    public void test() {
        int[] nums = {18, 17, 4, 1, 2, 22, 11, 8};
        Assertions.assertArrayEquals(new int[]{1, 2, 4, 8, 11, 17, 18, 22}, mergeSort(nums));
    }

    @Test
    public void test1() {
        int[] nums = {5,4,3,2};
        Assertions.assertArrayEquals(new int[]{2,3,4,5}, mergeSort(nums));
    }

    public int[] mergeSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) return; // base case {2,3} 0,1 ->{2}->0,{3}->0
        int mid = (start + end) / 2;
        sort(nums, start, mid); // left recursive call
        sort(nums, mid + 1, end); // right recursive calls
        mergeTwoArrays(nums, start, mid, end);
    }

    public void mergeTwoArrays(int[] nums, int start, int mid, int end){
        int p1=0, p2=0, index=start;
        int[] leftArray= Arrays.copyOfRange(nums, start, mid+1);
        int[] rightArray= Arrays.copyOfRange(nums, mid+1, end+1);

        while (p1<leftArray.length && p2<rightArray.length){
            if(leftArray[p1]<= rightArray[p2]){
                nums[index++]= leftArray[p1++];
            }else
                nums[index++]=rightArray[p2++];
        }
        while (p1<leftArray.length){
            nums[index++]=leftArray[p1++];
        }

        while (p2<rightArray.length){
            nums[index++]=rightArray[p2++];
        }
    }
}
