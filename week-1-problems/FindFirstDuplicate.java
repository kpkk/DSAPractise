import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class FindFirstDuplicate {


    @Test
    public void test() {
        int[] nums = {1, 3, 4, 2, 2};
        Assertions.assertEquals(2, findDuplicateWithFreqCount(nums));
    }

    public int findDuplicateWithSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return num;
        }
        return -1;
    }

    public int findDuplicateWithFreqCount(int[] nums) {
        int[] count = new int[nums.length];
        for (int num : nums) {
            count[num]++;
            if(count[num]>1) return num;
        }
        return -1;
    }

    public int findDuplicateNumber(int[] nums) {
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) {
                return idx;
            }
            nums[idx] = -nums[idx];
        }
        return -1;
    }
}
