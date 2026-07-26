package week5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {

    @Test
    public void test() {
        int[] nums = {5, 1, 4, 3, 2};
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, bucketSort(nums));
    }

    /**
     * Intution:
     * bring the minimum element to the left in each iteration
     *
     * @param nums
     * @return
     */
    public int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // swap i and min index
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    public int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
    }

    public int[] countSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        int[] freq = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        int index=0;
        for (int i = 0; i < freq.length; i++) {
            for (int j=0;j<freq[i];j++){
                nums[index++]=i;
            }
        }
        return nums;
    }

    public int[] bucketSort(int[] nums){
        if(nums==null && nums.length==0)return nums;
        int max=nums[0], min=nums[0];
        for (int num: nums){
            max=Math.max(max, num);
            min=Math.min(min, num);
        }
        int bucketCount=nums.length;
        int bucketCapacity= (max-min)/nums.length+1;
        ArrayList<Integer>[] buckets= new ArrayList[bucketCount];
        for (int i=0;i<bucketCount;i++){
            buckets[i]=new ArrayList<>();
        }
        for (int i=0;i<nums.length;i++){
            int bucketIndex= nums[i]-min/bucketCapacity;
            buckets[bucketIndex].add(nums[i]);
        }
        int index=0;
        for(ArrayList<Integer> bucket: buckets){
            Collections.sort(bucket);
            for(int i=0;i<bucket.size();i++){
                nums[index++]=bucket.get(i);
            }
        }
        return nums;
    }
}
