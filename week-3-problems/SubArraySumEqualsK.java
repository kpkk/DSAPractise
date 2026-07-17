package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class SubArraySumEqualsK {

    @Test
    public void test() {
        int[] nums = {1, 1, 1};
        int k = 2;
        Assertions.assertEquals(2, subArraySumEqualsK(nums,k));
    }

    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        int k = 3;
        Assertions.assertEquals(2, subArraySumEqualsK(nums,k));
    }

    @Test
    public void test2() {
        int[] nums = {1};
        int k = 0;
        Assertions.assertEquals(0, subArraySumEqualsK(nums,k));
    }

    @Test
    public void test3() {
        int[] nums = {-1, -1, 1};
        int k = 0;
        Assertions.assertEquals(1, subArraySumEqualsK(nums,k));
    }

    /**
     * Intialise integer variables sum and count with 0
     * Initialise a hashmap with integer as key and value
     * put a default entry (0,1) stating the sum 0 has occurred once, to handle the subarrays with 0 or single element with 0 case
     * iterate the array from left to right using pointer i
     * compute the running sum, check if sum-k is present in the hashmap, if yes add the sum-k value to count
     * insert the new entry if the sum has seen for first time, or update the occurrence
     *
     * TC: O(n)
     * SC: O(n)
     *
     * Intution: if the cumulative sum upto two indices is same, then the elements between those indices gives the sum 0
     *
     * if the cumulative sum up to two indices, say i and j is at a difference of k i.e.
     * if sum[i]−sum[j]=k, the sum of elements lying between indices i and j is k
     * @param nums
     * @param k
     * @return
     */

    public int subArraySumEqualsK(int[] nums, int k) {
        int sum=0, count=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)) count+=map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
