package week6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    @Test
    public void test() {
        int[] nums = {1, 2, 1};
        Assertions.assertArrayEquals(new int[]{2, -1, 2}, nextGreaterElementOptimised(nums));
    }

    public int[] nextGreaterElement(int[] nums) {
        int[] input = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            input[i] = nums[i];
        }
        for (int i = nums.length; i < input.length; i++) {
            input[i] = nums[i - nums.length];
        }
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[input.length];
        ans[ans.length - 1] = -1;
        for (int i = input.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && input[i] >= stack.peek()) {
                stack.pop();
                if (stack.isEmpty()) ans[i] = -1;
            }
            if (!stack.isEmpty() && input[i] < stack.peek()) {
                ans[i] = stack.peek();
            }
            stack.push(input[i]);
        }
        return Arrays.copyOfRange(ans, 0, nums.length);
    }

    public int[] nextGreaterElementOptimised(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans= new int[nums.length];
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[(i%nums.length)]>=stack.peek()){
                stack.pop();
            }
            ans[i%nums.length]= stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%nums.length]);
        }
        return ans;
    }
}
