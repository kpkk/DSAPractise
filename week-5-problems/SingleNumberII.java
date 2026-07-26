package week5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingleNumberII {

    @Test
    public void test(){
        int[] nums={2,2,3,2};
        Assertions.assertEquals(3, singleNUmber(nums));
    }

    @Test
    public void test1(){
        int[] nums={0,1,0,1,0,1,13};
        Assertions.assertEquals(13, singleNUmber(nums));
    }
    /**
     * intution:
     * every integer can be represented in binary form using 32 bits
     * iterate the all the bits from 0->32
     *  - for every bit, go over all the elements in array
     *      - if the bit is set count++;
     *  - check if the count is divisible by 3 ( in array except single ele, every element is expected to be repeated thrice)
     *      - if the count is divisible, which means the bits are set only by
     *          the repeated numbers the answer element will not have this bit set
     *       - if not divisible, this bit will be set in the answer element, may be as well as in teh repeated elements
     *          - set that bit to ans variable n | (1<<i)
     *  - retrun the forned numebr
     * @param nums
     * @return
     */
    public int singleNUmber(int[] nums){
        int ans=0;
        for (int i=0;i<32;i++){
            int count=0;
            // i=0, 1, 2
            // the below loop checks, how many elements in the array have the ith bit set
            for (int j=0;j<nums.length;j++){
                // 2 & (1<<0)  2 & (1<<1), 2&(1<<2)
                boolean isSet = (nums[j] & (1<<i) )!=0;
                if (isSet) count++;
            } // 3& (1<<0) => 011
            if(count %3 !=0){
                ans = ans |(1<<i); //1101
            }
        }

        return ans;
    }
}