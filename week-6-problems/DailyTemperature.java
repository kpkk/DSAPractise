package week6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class DailyTemperature {

    @Test
    public void test(){
        int[] nums={73,74,75,71,69,72,76,73};
        Assertions.assertArrayEquals(new int[]{1,1,4,2,1,1,0,0}, dailyTemperatures(nums));
    }

    public int[] dailyTemperatures(int[] nums){

        // declare the array to store the day differences and return
        int[] ans= new int[nums.length];
        // stack to store the day index,
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<nums.length;i++){
            // as long as the temperature on the ith day is greater than stack.peek() i.e. some previous day which hasn't be concluded
            // write the difference of i- stack.pop() as that gives the number of days of wait
            while (!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                int day= stack.peek();
                ans[day]=i-stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
