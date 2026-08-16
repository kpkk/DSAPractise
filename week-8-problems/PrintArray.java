package week8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrintArray {

    @Test
    public void test(){
        int[] nums={1,2,3,4};
        print(0, nums);
    }
    // TC: unit of work done by one recursive call * the number of calls
    // O(1)* O(n) -> O(n)
    // SC: O(1) + O(n) -> this is for call stack
    public void print(int index, int[] nums){
        // base case
        if(index==nums.length) // O(1)
            return;
        // logic
        System.out.println(nums[index]); // O(1)
        // recurrence relation
        print(index+1,nums); // O(1)

    }
}
