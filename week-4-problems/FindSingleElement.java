package week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindSingleElement {

    @Test
    public void test(){
        int[] nums={2,2,1};
        Assertions.assertEquals(1, findSingleElement(nums));
    }

    public int findSingleElement(int[] nums){
        int xor=0;
        for (int i=0;i<nums.length;i++){
            xor^=nums[i];
        }
        return xor;
    }
}
