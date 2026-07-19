package week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstAndLastPosition {

    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        Assertions.assertArrayEquals(new int[]{3, 4}, findPositions(nums, target));
    }
    @Test
    public void test1() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        Assertions.assertArrayEquals(new int[]{-1, -1}, findPositions(nums, target));
    }

    public int[] findPositions(int[] nums, int target) {

        int firstIndex= binarySearch(nums, target, true); // do a left binary search
        int secondIndex= binarySearch(nums, target, false); // right binary search
        return new int[]{firstIndex, secondIndex};
    }

    public int binarySearch(int[] nums, int target, boolean isLeftSearch){
        int low=0, high=nums.length-1, index=-1;
        while (low<=high){
            int mid= low+(high-low)/2;
            if(nums[mid]==target){
                index=mid; // found an index, but not sure, if its
                            // - first index or last index,
                // whether the other index, would be on the left or right side
                // some more logic goes here
                if (isLeftSearch) high=mid-1;
                else low=mid+1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else low=mid+1;
        }
        return index;
    }


    public int[] findPositionsDup(int[] nums, int target) {

        int firstIndex= binarySearchLeft(nums, target); // do a left binary search
        int secondIndex= binarySearchRight(nums, target); // right binary search
        return new int[]{firstIndex, secondIndex};
    }

    public int binarySearchLeft(int[] nums, int target){
        int low=0, high=nums.length-1, index=-1;
        while (low<=high){
            int mid= low+(high-low)/2;
            if(nums[mid]==target){
                index=mid; // found an index, but not sure, if its
                // - first index or last index,
                // whether the other index, would be on the left or right side
                // some more logic goes here
                high=mid-1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else low=mid+1;
        }
        return index;
    }

    public int binarySearchRight(int[] nums, int target){
        int low=0, high=nums.length-1, index=-1;
        while (low<=high){
            int mid= low+(high-low)/2;
            if(nums[mid]==target){
                index=mid; // found an index, but not sure, if its
                // - first index or last index,
                // whether the other index, would be on the left or right side
                // some more logic goes here
                 low=mid+1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else low=mid+1;
        }
        return index;
    }
}
