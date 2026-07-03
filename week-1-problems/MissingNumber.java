import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Enumeration;

public class MissingNumber {


    @Test
    public void test(){
        int[] nums={3,0,1};
        Assertions.assertEquals(2, findMissingOpt(nums));
    }

    /**
     * Initialise an integer array map with size n+1;
     * iterate the input array and flip the index in the map array with 1 for the seen element
     * iterate the map array and
     *  - check if the value is 0 for any index return that as ans
     *  - else continue
     * TC: O(n) SC: O(n)
     *
     */
    public int findMissing(int[] nums){
        int[] map= new int[nums.length+1];
        for (int i=0;i<nums.length;i++){
            map[nums[i]]=1;
        }

        for (int i=0;i<map.length;i++){
            if(map[i]==0) return i;
        }
        return -1;
    }

    /**
     * Initialise two integer variables called actualtSum=0 and expected SUm with sum of natural number upto n
     * iterate the input array and compute the running sum
     * return the difference of expected sum - actual sum as an answer, that must be the missing number
     * TC: O(n) SC: O(1)
     *
     */

    public int findMissingOpt(int[] nums){
        int n = nums.length;
        int actualSum=0;
        int expectedAns= n*(n+1)/2;
        for(int i=0;i<nums.length;i++){
            actualSum+=nums[i];
        }
        return expectedAns-actualSum;
    }


}
