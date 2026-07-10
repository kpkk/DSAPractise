package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PushZeroesToRight {

    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 12};
        Assertions.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, moveZeroesWithSpace(nums));
    }

    @Test
    public void test1() {
        int[] nums = {0};
        Assertions.assertArrayEquals(new int[]{0}, moveZeroes(nums));
    }

    /***
     * Initialise two pointers left=0, right=0, to act as pointers for iteration
     * right being a fast pointer iterates the array from left to right
     * if the value at the current index is non zero, move left by swapping
     *  - read the value at left pointer into a temp variable
     *  - move the value at right into left
     *  - load the temp into right
     * continue to swap as stated above till the end of array, automatically all zeroes are moved towards right
     * TC: O(n)
     * SC: O(1)
     */

    public int[] moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right] = temp;
            }
            right++;
        }
        return nums;
    }

    /***
     *
     * Initialise a new integer array of input length
     * initialise an integer variable called index as a pointer
     * iterate the input array from left to right using pointer i
     * if the value at the index is non-zero. then copy that element in new array and increment the index
     * keeping doing the same till the end of the array
     * return output arrau
     * TC: O(n)
     * SC: O(n)
     *
     */

    public int[] moveZeroesWithSpace(int[] nums) {
        int[] output = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                output[index++] = nums[i];
        }
        return output;
    }
}
