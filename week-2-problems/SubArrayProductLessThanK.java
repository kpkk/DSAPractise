package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubArrayProductLessThanK {

    @Test
    public void test() {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        Assertions.assertEquals(8, numSubArrayProductLessThanK(nums, k));
    }

    /***
     * Initialise integer variables left, right=0, mul=1 to multiply
     * while right less than the length of an array, iterate
     * multiply nums[right] with mul and store that back into mul
     * as long as mul>=k, try to divide the number from left and increment left to reduce the multiplication total so far to bring under k
     * once the inner loop exits take right-left+1 and accumulate into count variable to count the number of sub arrays
     * increment right
     * return count in the end
     *
     * TC: O(n)
     * SC: O(1)
     *
     */

    public int numSubArrayProductLessThanK(int[] nums, int k) {
        int mul = 1;
        int right = 0, left = 0, count = 0;
        while (right < nums.length) {
            mul = nums[right] * mul;
            while (mul >= k) {
                mul /= nums[left];
                left++;
            }
            count+=right-left+1;
            right++;
        }
        return count;
    }
}
