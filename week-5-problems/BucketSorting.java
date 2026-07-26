package week5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSorting {

    @Test
    public void test() {
        int[] nums = {5, 1, 4, 3, 2, 10, 20, 15, 16, 8};
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, bucketSort(nums));
    }

    public int[] bucketSort(int[] nums){
        // find min and max -> to define the range of elements in the array
        int max=Integer.MIN_VALUE, min= Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++){
            max= Math.max(max, nums[i]);
            min= Math.min(min, nums[i]);
        }
        // no of buckets required
        int noOfBuckets= nums.length;
        // compute the capacity of the bucket
        int capacity= (max-min)/nums.length+1;

        // inside the bucket, list to hold the values
        ArrayList<Integer>[] list= new ArrayList[noOfBuckets];

        // iterate the buckets, initialise them w/ empty lists, so that they can store elements
        for (int i=0;i<noOfBuckets;i++){
            list[i]=new ArrayList<>();  //[Arrays.asList(), Arrays.asList(),]
        }
        // iterate the input array, find the bucket index store the elements
        for (int i=0;i<nums.length;i++){
            int bucketIndex = (nums[i]-min)/capacity;
            list[bucketIndex].add(nums[i]);
        }

        // sort all the lists internally and then form the output
        int index=0;
        for (int i=0;i<noOfBuckets;i++){
            Collections.sort(list[i]);
            for(int j=0;j<list[i].size();j++){
                nums[index++]=list[i].get(j);
            }
        }
        return nums;
    }
}
