package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RightRotateArray {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Assertions.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, rotateArray(nums, 3));
    }

    /**
     * take % version of k, k%nums.length to know the min no of rotations when the k is bigger than array size
     * initilaise two pointers left=0, right=lenght-1, traverse in opp direction
     * while they both meet , keep swapping left and right, reverse the entire array
     * reverse the sub array from 0, k-1
     * reverse the sub array from k to length-1
     * @param nums
     * @param k
     * @return
     */

    public int[] rotateArray(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        k %= nums.length;
        while (left < right) {
            int temp = nums[right];
            nums[right--] = nums[left];
            nums[left++] = temp;
        }
        left = 0;
        right = k - 1;
        while (left < right) {
            int temp = nums[right];
            nums[right--] = nums[left];
            nums[left++] = temp;
        }
        left = k;
        right = nums.length - 1;
        while (left < right) {
            int temp = nums[right];
            nums[right--] = nums[left];
            nums[left++] = temp;
        }
        return nums;
    }

    public int[] rotateArrayBruteForce(int[] nums, int k) {
        String s = "";
        String output = "";
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
        }
        String substring = s.substring(k + 1);
        output = substring + s.substring(0, k + 1);
        for (int i = 0; i < output.length(); i++) {
            nums[i] = Character.getNumericValue(output.charAt(i));
        }
        return nums;
    }
}
