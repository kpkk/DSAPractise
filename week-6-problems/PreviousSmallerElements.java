package week6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class PreviousSmallerElements {

    @Test
    public void test() {
        int[] nums = {1, 5, 0, 3, 2, 4};
        Assertions.assertArrayEquals(new int[]{-1, 1, -1, 0, 0, 2}, findPreviousSmaller(nums));
    }

    @Test
    public void test1() {
        int[] nums = {1, 5, 5, 3, 2, 2, 4};
        Assertions.assertArrayEquals(new int[]{-1, 1, 1, 1, 1,1, 2}, findPreviousSmaller(nums));
    }

    @Test
    public void test2() {
        int[] nums = {8, 8, 2, 2, 4, 9, 1, 1, 5, 10};
        Assertions.assertArrayEquals(new int[]{-1, -1, -1, -1, 2, 4, -1, -1, 1, 5}, findPreviousSmaller(nums));
    }

    public int[] findPreviousSmaller(int[] nums){
        int[] output= new int[nums.length];
        output[0]=-1;
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<nums.length;i++){
            while (!stack.isEmpty() && nums[i]<=stack.peek()){
                stack.pop();
                if(stack.empty())
                    output[i]=-1;
            }
            if(!stack.isEmpty() && nums[i]>stack.peek()){
                output[i]=stack.peek();
            }

            stack.push(nums[i]);
        }
        return output;
    }
}
