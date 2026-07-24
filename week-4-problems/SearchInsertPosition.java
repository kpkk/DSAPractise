package week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchInsertPosition {

    @Test
    public void test(){
        int[] nums={1,3,5,6};
        int target=5;
        Assertions.assertEquals(2, findPosition(nums, target));
    }

    @Test
    public void test1(){
        int[] nums={1,3,5,6};
        int target=2;
        Assertions.assertEquals(1, findPosition(nums, target));
    }

    /**
     * initialise pointers, low=0, high=nums.length
     * while low and high are not reached on to the same index
     * compute mid index
     *  - if the value at mid ==target return mid
     *  - else if the value at mid greater than mid then move high=mid-1
     *  - else move low=mid+1 to right
     *
     *  return the low in the end, as that will be the idle position at which the number should be present
     * @param nums
     * @param target
     * @return
     */

    public int findPosition(int[] nums, int target){
        int low=0, high=nums.length-1;
        while (low<=high){
            int mid= low+(high-low)/2;
            if(nums[mid]==target) return mid;
            else if (nums[mid]> target) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}
