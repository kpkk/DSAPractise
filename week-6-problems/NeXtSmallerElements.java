package week6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NeXtSmallerElements {

    @Test
    public void test(){
        int[] nums={4, 8, 5, 2, 25};
        Assertions.assertArrayEquals(new int[]{2, 5, 2, -1, -1}, findNextSmaller(nums));
    }

    @Test
    public void test1(){
        int[] nums={8, 8, 2, 2, 4, 9, 1, 1, 5, 10};
        Assertions.assertArrayEquals(new int[]{2, 2, 1, 1, 1, 1, -1, -1, -1, -1}, findNextSmaller(nums));
    }

    @Test
    public void test2(){
        int[] nums={4, 8, 5, 2, 25};
        Assertions.assertEquals(Arrays.asList(2, 5, 2, -1, -1), findNextSmallerList(nums));
    }

    public int[] findNextSmaller(int[] nums){
        int[] ans= new int[nums.length];
        ans[ans.length-1]=-1;
        Stack<Integer> stack= new Stack<>();
        for (int i=nums.length-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek()>=nums[i]){
                stack.pop();
                if(stack.isEmpty()) ans[i]=-1;
            }
            if(!stack.isEmpty() && stack.peek() < nums[i]){
                ans[i]=stack.peek();
            }
            stack.push(nums[i]);
        }
        return ans;
    }

    public ArrayList<Integer> findNextSmallerList(int[] nums){
        ArrayList<Integer> ans= new ArrayList<>();
        Stack<Integer> stack= new Stack<>();
        ans.add(-1);
        for (int i=nums.length-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek()>=nums[i]){
                stack.pop();
                if(stack.isEmpty()) ans.add(-1);
            }
            if(!stack.isEmpty() && stack.peek() < nums[i]){
                ans.add(stack.peek());
            }
            stack.push(nums[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
}
