package week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchInRotatedArrayII {

    @Test
    public void test(){
        int[] nums={2,5,6,0,0,1,2};
        int target=0;
        Assertions.assertTrue(search(nums, target));
    }

    @Test
    public void test1(){
        int[] nums={2,5,6,0,0,1,2};
        int target=3;
        Assertions.assertFalse(search(nums, target));
    }

    @Test
    public void test2(){
        int[] nums={1,0,1,1,1};
        int target=0;
        Assertions.assertTrue(search(nums, target));
    }

    /**
     *
     * Initialise two pointers, low=0, high=nums.length-1
     * while low and high are not meeting on the same index
     *  - compute mid point
     *  - if value at mid is target return true
     *  - if value and low less than or equal to value at mid (check if left side is sorted
     *      - check if the target is present in the low and mid range
     *          - if yes, move high=mid-1
     *          - else, move low=mid+1
     *   - if value at mid is less than or equal to value at high
     *      - check if the target is present in the mid to high range
     *          - if yes, move the low=mid+1;
     *          - else, move high=mid-1
     *  return false in the end, if number not found
     * @param nums
     * @param target
     * @return
     */

    public boolean search(int[] nums, int target){
        int low=0, high=nums.length-1;
        while (low<=high){
            int mid= low+(high-low)/2;
            if (nums[mid]==target) return true;
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low=low+1;
                high=high-1;
                continue;
            }
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<=nums[mid]) high=mid-1;
                else low=mid+1;
            }
            else {
                if(target>=nums[mid] && target<=nums[high]) low=mid+1;
                else high=mid-1;
            }
        }
        return false;
    }
}
