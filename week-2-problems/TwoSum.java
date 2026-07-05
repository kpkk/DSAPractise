package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoSum {


    @Test
    public void test() {
        int[] arr = {1, 4, 5, 8, 11, 12, 16, 21};
        int target = 19;
        Assertions.assertArrayEquals(new int[]{3, 4}, twoSum(arr, target));
    }

    /***
     * Initialise two variables (pointers) left=0, right= arr.length-1
     * iterate the array from both the ends till left and right crosses
     * compute sum, add the value at left and right index
     *  - if the sum is equal to target return the indices as an array
     *  - else if the sum is lesser than target then increment left
     *  - else decrement right
     * TC: O(n)
     * SC:O(1)
     *
     */

    public int[] twoSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) return new int[]{left, right};
            else if (sum > target) right--;
            else left++;
        }
        return new int[]{-1, -1};
    }
}
