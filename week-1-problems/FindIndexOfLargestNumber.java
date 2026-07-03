import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindIndexOfLargestNumber {


    @Test
    public void test() {
        int[] nums = new int[]{1, 10, 3, 10, 4};
        Assertions.assertEquals(3, findIndex(nums));
    }

    @Test
    public void test1() {
        int[] nums = new int[]{1, 3, 10, 4};
        Assertions.assertEquals(2, findIndex(nums));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{1};
        Assertions.assertEquals(0, findIndex(nums));
    }

    public int findIndex(int[] nums) {
        if (nums == null) throw new RuntimeException("array can't be null");
        if (nums.length == 1) return 0;
        int max = nums[0];
        int lastIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= max) {
                lastIndex = i;
                max = nums[i];
            }
        }
        return lastIndex;
    }
}
