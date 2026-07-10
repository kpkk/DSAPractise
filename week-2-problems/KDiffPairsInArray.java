package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KDiffPairsInArray {

    @Test
    public void test() {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        Assertions.assertEquals(2, findPairsHashing(nums, k));
    }

    @Test
    public void test1() {
        int[] nums = {1, 3, 1, 5, 4};
        int k = 0;
        Assertions.assertEquals(1, findPairsHashing(nums, k));
    }

    @Test
    public void test2() {
        int[] nums = {1, 1, 1, 1, 1};
        int k = 0;
        Assertions.assertEquals(1, findPairsHashing(nums, k));
    }

    /** Not working for all TCs
     * Sort the array in ascending order
     * initialise pointers such as left=0 and right=1, count=0
     * check the difference between the values at left and right
     * - if the diff is greater than k, then increment left
     * - if the diff is less than k then increment right
     * - if equals increment count
     * TC: O(nlogn)
     * SC: O(1)
     */

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 1, count = 0;
        while (right < nums.length) {
            if (nums[right] - nums[left] == k) {
                count++;
                left++;
                right++;
            } else if (nums[right] - nums[left] < k) {
                right++;
            } else {
                left++;
                if (left == right) right++;
            }
        }
        return count;
    }

    /**
     * Initialise a hashmap with integer as key and value and count  variable to find answer
     * iterate the array from left to right and load all the chars into map with key as number and value as number of occurrences
     * take the entry set and iterate to eliminate the duplicates
     *  - if k=0, and the number is repeated more than once and increment count
     *  - if k!=0, then check if map contains (nums[i]+k) present in its key set, if yes increment count
     *  return count
     * TC: O(nlogn), worst case O(n) average case
     * SC: O(n)
     *
     */

    public int findPairsHashing(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (k == 0 && entry.getValue() > 1 || k > 0 && map.containsKey(entry.getKey() + k)) count++;
        }
        return count;
    }
}
