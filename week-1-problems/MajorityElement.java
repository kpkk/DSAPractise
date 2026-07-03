import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorityElement {


    @Test
    public void test() {
        int[] nums = {3, 2, 3};
        Assertions.assertEquals(3, findMajorityOptimised(nums));
    }

    @Test
    public void test1() {
        int[] nums = {2,2,1,1,1,2,2};
        Assertions.assertEquals(2, findMajorityOptimised(nums));
    }

    @Test
    public void test3() {
        int[] nums = {3,3,4};
        Assertions.assertEquals(3, findMajorityOptimised(nums));
    }

    /**
     * Pseudo code:
     * Check if the nums is null then throw exception
     * Initialise a hashmap with Integer as key and value
     * iterate the array and book keep the number and its occurrences in the map
     * iterate the entry set of a map, check if the value of an entry is greater than n/2 then return
     *
     * TC: O(n), SC: O(n)
     */

    public int findMajorityEle(int[] nums) {
        if (nums == null) throw new RuntimeException("Array can't be null");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > nums.length / 2) return entry.getKey();
        }
        return -1;
    }


    /**
     * Boyre moore voting technique:
     *  initialise a variable called major with first element in the array and count to be 1
     *  iterate the nums array from index until the last index
     *  if count==0 then switch the majority element with the value at the index (the streak got over)
     *  if the number at the index is equal to majority element then count++
     *      else count--
     *  at the end return major ele
     *
     *  TC: O(n), SC:O(1)
     */

    public int findMajorityOptimised(int[] nums){
        int major=nums[0];
        int count=1;
        for (int i=1;i<nums.length;i++){
            if(count==0) major=nums[i];
            if(nums[i]==major){
                count++;
            }
            else
                count--;
        }
        return major;
    }
}
