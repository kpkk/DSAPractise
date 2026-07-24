package week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MissingNumber {

    @Test
    public void test() {
        int[] nums = {3, 0, 1};
        Assertions.assertEquals(2, missingNumber(nums));
    }

    @Test
    public void test1() {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        Assertions.assertEquals(8, missingNumber(nums));
    }

    /**
     * Intialise the ans variable with zero
     * iterate the loop from 1 until n, no harm in starting with i=0 as well, but 0^0=0 , involves one extra operation
     * xor the ans variable with i and increment i till the end of loop
     * iterate the given array from index -0 till n-1
     * xor ans with nums[i]
     * return ans
     * @param nums
     * @return
     *
     * Intuition: XoR of two same numbers is zero 3^3=0
     *            anything we XOR with 0, gives the number itself 1^0=1
     *            so take xor of all numbers from [0....n]
     *            take the xor of array numbers
     *            all the duplicate pairs will be cancelled out
     *            only the number that occurred in first loop which is missing in array remains
     *            Eg: [3,0,1]
     *            ans= 0^1^2^3 => 0 (result is zero)
     *            0^1^2^3^3^0^1 => (0^0)^(3^3)^(1^1)^2
     *            from the formula xor of same numbers is zero we will have 2 as answer
     *
     */

    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 1; i <= nums.length; i++) {
            ans ^= i;
        }
        for (int i=0;i<nums.length;i++){
            ans ^= nums[i];
        }
        return ans;
    }

    /**
     *  Intialise the ans variable with nums.length (because from the loop the iteration goes from 0-n-1 so we need to involve n
     *  iterate the loop from 0 until n-1
     *  xor the ans variable with i and increment i till the end of loop
     *  xor ans with nums[i]
     *  return ans
     * Intuition: XoR of two same numbers is zero 3^3=0
     * anything we XOR with 0, gives the number itself 1^0=1
     * so take xor of all numbers from [0....n]
     * take the xor of array numbers
     * all the duplicate pairs will be cancelled out
     * only the number that occurred in first loop which is missing in array remains
     * Eg: [3,0,1]
     * ans= 0^1^2^3 => 0 (result is zero)
     * 0^1^2^3^3^0^1 => (0^0)^(3^3)^(1^1)^2
     * from the formula xor of same numbers is zero we will have 2 as answer
     */


    public int missingNumberOnePass(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ i;
            ans = ans ^ nums[i];
        }
        return ans;
    }
}




