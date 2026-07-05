package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrefixSum {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(new int[]{1, 3, 6, 10, 15}, prefixSum(nums));
    }

    public int[] prefixSum(int[] nums) {
        int[] ps = new int[nums.length];
        ps[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            ps[i]=ps[i-1]+nums[i];
        }
        return ps;
    }
}
