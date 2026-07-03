import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlusOne {

    /***
     * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
     *
     * Increment the large integer by one and return the resulting array of digits.
     *
     *
     *
     * Example 1:
     *
     * Input: digits = [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Incrementing by one gives 123 + 1 = 124.
     * Thus, the result should be [1,2,4].
     * Example 2:
     *
     * Input: digits = [4,3,2,1]
     * Output: [4,3,2,2]
     * Explanation: The array represents the integer 4321.
     * Incrementing by one gives 4321 + 1 = 4322.
     * Thus, the result should be [4,3,2,2].
     * Example 3:
     *
     * Input: digits = [9]
     * Output: [1,0]
     * Explanation: The array represents the integer 9.
     * Incrementing by one gives 9 + 1 = 10.
     * Thus, the result should be [1,0].
     */

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        Assertions.assertArrayEquals(new int[]{1, 2, 4}, plusOneOpt(nums));
    }

    @Test
    public void test1() {
        int[] nums = {4, 3, 2, 1};
        Assertions.assertArrayEquals(new int[]{4, 3, 2, 2}, plusOneOpt(nums));
    }

    @Test
    public void test2() {
        int[] nums = {9};
        Assertions.assertArrayEquals(new int[]{1, 0}, plusOneOpt(nums));
    }

    @Test
    public void test3() {
        int[] nums = {3, 8, 6, 9};
        Assertions.assertArrayEquals(new int[]{3, 8, 7, 0}, plusOneOpt(nums));
    }

    @Test
    public void test4() {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Assertions.assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1}, plusOneOpt(nums));
    }

    @Test
    public void test5() {
        int[] nums = {9, 9, 9, 9};
        Assertions.assertArrayEquals(new int[]{3, 8, 7, 0}, plusOneOpt(nums));
    }

    /***
     * initialise a variable called sum and iterate the nums array and convert the array representation into a whole number
     * increment sum by 1 and assigning it back
     * find the number of digits in the number
     * Create an array of length one greater than the number digits
     * iterate the new arrray and start filling the each digit from the last
     *
     * TC: O(n) SC:O(n)
     */

    public int[] plusOne(int[] digits) {
        if (digits == null) throw new RuntimeException("input array can't be null");
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum = sum * 10 + digits[i];
        }
        sum += 1;
        // count the digits
        int temp = sum;
        int count = 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        int[] output = new int[count];
        for (int i = output.length - 1; i >= 0; i--) {
            output[i] = sum % 10;
            sum /= 10;
        }
        return output;

    }

    /***
     * iterate the array from last
     *  - if the last digit is less than 9 then do a +1
     *  - return the array Eg: [5,6]->[5,7], [3,6,8]-> [3,6,9]
     *  - if not make the current digit as 0
     *      eg -> [3,7,9]-> [3,7,0]
     *      - in the next iteration the last but one number will be evaluated and modified as per above process Eg: [3,6,0] -> [3,7,0]
     *      - return the array
     *  - create a new array with +1 more to the length of the input array
     *      - This is used to handle the scenario of [9], [9,9], [9,9,9,9]
     *          - after going through the above steps the input array [9] would become [0]
     *          - then the new array created would look like [0,0]
     *          - turn the first digit in the array as 1 so [0,0] -> [1,0]
     *
     * TC: O(n) SC: O(n)
     */
    public int[] plusOneOpt(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }

}
