import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class SingleNumber {


    @Test
    public void test() {
        int[] nums = {2, 2, 1};
        Assertions.assertEquals(1, singleNumberOpt(nums));
    }

    @Test
    public void test1() {
        int[] nums = {4, 1, 2, 1, 2};
        Assertions.assertEquals(4, singleNumberOpt(nums));
    }

    /***
     * Initialise a hashmap with Integer as key and value
     * iterate the array from left to right and put the num and frequency
     * get the entry set and iterate
     *  - if the value of any key is 1 return
     *  TC: O(n) SC: O(n)
     */

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }

    public int singleNumberWithList(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                list.remove(Integer.valueOf(nums[i]));
                continue;
            }
            list.add(nums[i]);
        }
        return list.getFirst();
    }

    /**
     * using bit manipulation:
     *  XOR is a digital gate
     *      - XOR of two numbers is 0
     *      - any number we XOR with 0 will result that number itself
     *      - in XOR if the two bits are distinct then result is 1
     *      - XOR between two bits is 0 when both are same either 1s or 0s
     * initialise a variable called result=0
     * iterate the array from start to end index
     * do xor with result and value at index and store the result into result variable
     * keeping doing till the end of the array
     * return results
     * TC: O(n) SC: O(n)
     */
    public int singleNumberOpt(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
