package week5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SingleNumberIII {

    @Test
    public void test() {
        int[] nums = {1, 2, 1, 3, 2, 5};
        Assertions.assertArrayEquals(new int[]{3, 5}, singleElements(nums));
    }

    public int[] singleElements(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        int xorIndex = -1;


        for (int i = 0; i < 32; i++) {
            if ((xor & (1 << i)) != 0){
                xorIndex=i;
                break;
            }
        }

        ArrayList<Integer> setGroup = new ArrayList<>();
        ArrayList<Integer> unSetGroup = new ArrayList<>();
        for (int i=0;i< nums.length;i++){
            if((nums[i] & (1<<xorIndex)) !=0){
                setGroup.add(nums[i]);
            }else unSetGroup.add(nums[i]);
        }
        // do xor in both the lists and find the unique
        int group1Xor=0, group2Xor=0;
        for(int ele: setGroup){
            group1Xor ^= ele;
        }
        for(int ele: unSetGroup){
            group2Xor ^= ele;
        }
        return new int[]{group1Xor, group2Xor};
    }
}
