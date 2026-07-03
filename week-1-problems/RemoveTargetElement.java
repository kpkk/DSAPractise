import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveTargetElement {


    @Test
    public void test() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        Assertions.assertEquals(2, removeEle(nums, val));
    }

    @Test
    public void test1() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        Assertions.assertEquals(5, removeEle(nums, val));
    }

    public int removeEle(int[] nums, int val) {
        int left=0, right=0;
        while (right<nums.length){
            if(nums[right]!=val){
                int temp= nums[left];
                nums[left++]=nums[right];
                nums[right]=temp;
            }
            right++;
        }
        return left;
    }
}
