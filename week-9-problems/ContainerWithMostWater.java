package week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContainerWithMostWater {

    @Test
    public void test(){
        int[] heights={1,8,6,2,5,4,8,3,7};
        Assertions.assertEquals(49, containerWithMostWater(heights));
    }

    /**
     * Think of each number in height as a wall, and we get to pick any two walls to hold water between them.
     *
     * The water held only ever reaches as high as the shorter of the two walls, since water spills over the shorter side.
     *
     * So the amount of water is just the shorter wall's height, multiplied by how far apart the two walls are.
     *
     * Checking every single pair of walls would work, but it would take too long. There is a smarter way to only look at the pairs that could possibly be the best one.
     *
     * If we start with the two walls furthest apart, the width is already as big as it can be. From there, moving the shorter wall inward is the only move that has a chance of finding something taller, and therefore better.
     * @param heights
     * @return
     */

    public int containerWithMostWater(int[] heights){
        int left=0, right=heights.length-1;
        int max=0;
        while (left<right){
            int gap=right-left;
            int wallHeight= Math.min(heights[left], heights[right]);
            max=Math.max(max, wallHeight*gap);

            if (heights[left]<heights[right])
                left++;
            else right--;
        }
        return max;
    }
}
